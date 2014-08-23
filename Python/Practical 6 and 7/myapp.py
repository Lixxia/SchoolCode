import webapp2
from google.appengine.api import users
import os
import urllib
from google.appengine.ext.webapp import blobstore_handlers
from google.appengine.ext import blobstore
from second import *

class Upload(blobstore_handlers.BlobstoreUploadHandler):
        def post(self):
                upload_files = self.get_uploads('myUploadedFile')
                blob_info = upload_files[0]
                self.response.out.write('<html><body>')
                self.response.out.write('Uploaded file: ' + str(blob_info.filename))
                self.response.out.write('<br>Link to file: ')
                self.response.out.write('<a href="/serve/%s">%s</a>' % (blob_info.key(), blob_info.filename))
                self.response.out.write('</body></html>')

class MainPage(webapp2.RequestHandler):
	def get(self):
                upload_url = blobstore.create_upload_url('/upload')
                user = users.get_current_user()
		if user:
                        self.response.out.write('<html><body>')
                        self.response.out.write('Welcome ' + user.nickname() + '<br>')
                        self.response.out.write('<b>This works I swear</b><br>')
                        self.response.out.write('<form action="%s" method="POST" enctype="multipart/form-data">' % upload_url)
                        self.response.out.write("""Upload File: <input type="file" name="myUploadedFile"><br />""")
                        self.response.out.write("""<input type="submit" name="submit" value="Submit"> </form>""")
                        for blob_info in blobstore.BlobInfo.all():
                                self.response.out.write('<br>Link to file: ')
                                self.response.out.write('<a href="/serve/%s">%s</a>' % (blob_info.key(), blob_info.filename))
                        self.response.out.write('</body></html>')
		else:
                        self.redirect(users.create_login_url(self.request.url))

class ServeFile(blobstore_handlers.BlobstoreDownloadHandler):
        def get(self,resource):
                resource = str(urllib.unquote(resource))
                blob_info = blobstore.BlobInfo.get(resource)
                self.send_blob(blob_info)

application = webapp2.WSGIApplication([
    ('/', MainPage),('/upload', Upload),('/secondexercise', SecondMainPage),('/message', HandleMessage),('/serve/([^/]+)?', ServeFile),
], debug=True)

