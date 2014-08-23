import webapp2
from google.appengine.ext import ndb
import cgi
import os
import urllib
from google.appengine.ext.webapp import blobstore_handlers
from google.appengine.ext import blobstore

class Message(ndb.Model):
    message_from = ndb.StringProperty()
    message_text = ndb.StringProperty()
    message_time = ndb.DateTimeProperty(auto_now=True)

class HandleMessage(blobstore_handlers.BlobstoreUploadHandler):
    def post(self):
        self.response.out.write('<html><body>')
        self.response.out.write('<a href="/secondexercise">Back to Second Main Page</a><br>')
        upload_files = self.get_uploads('myUploadedFile')
        invalid = False;
        if upload_files:
            blob_info = upload_files[0]
            fn = (blob_info.filename).split(".")[-1]
            if fn == "txt" or fn == "pdf" or fn == "doc":
                self.response.out.write('Uploaded file: <a href="/serve/%s">%s</a>' % (blob_info.key(), blob_info.filename))
            else:
                invalid = True;
                blobstore.delete(blob_info.key())
                self.response.out.write('<br>File extension not valid.')
        m_from = self.request.get('from')
        m_text = self.request.get('text')
        message = Message(message_from=m_from, message_text=m_text)
        if invalid:
            self.response.out.write('<br>File not uploaded, message not submitted.')
        else:
            self.response.out.write('<br>Message Submited.')
            message.put()
        self.response.out.write('</body></html>')

class SecondMainPage(webapp2.RequestHandler):
    def get(self):
        upload_url = blobstore.create_upload_url('/message')
        self.response.out.write('<html><body>')
        self.response.out.write('<h1>Second Main Page</h1>')
        self.response.out.write('All fields must be filled.<br>Please use only valid file types: .txt, .pdf or .doc<br/>')
        self.response.out.write('<form action="%s" name ="myform" method="POST" enctype="multipart/form-data">' %upload_url)
        self.response.out.write('From: <input type="text" name="from" required> <br/>')
        self.response.out.write('Message: <input type="text" name="text" required><br/>')
        self.response.out.write('Upload File: <input type="file" name="myUploadedFile" required><br/>')
        self.response.out.write('<input type="submit" value="Submit" name="submit"></form>')
        messages = Message.query().order(-Message.message_time).fetch(10)
        self.response.out.write('<table><tr><td>')
        for msg in messages:
            self.response.out.write('<blockquote>Name: %s , Message: %s , </blockquote>'% (cgi.escape(msg.message_from),cgi.escape(msg.message_text)))
        self.response.out.write('</td><td>')
        for blob_info in blobstore.BlobInfo.all():
            self.response.out.write('<blockquote>File: <a href="/serve/%s">%s</a></blockquote>' %(blob_info.key(), blob_info.filename))
        self.response.out.write('</td></tr></table>')
        self.response.out.write('</body></html>')