# Overview
This is a compilation of code I've created or worked on over the years for school-related projects. Most of it is self explanatory or documented, but for the more complicated things I'll be outlining the purpose.

## Major Projects
These projects are generally semester-long endeavors. The code for them is hosted on Github and linked below. Further explanations can be found in the associated readme.
[Databases Project (CSCI332)](https://github.com/Lixxia/db-orchestra)
[Software Engineering I Project (CSCI362)](https://github.com/Lixxia/CSCI362)
[Compiler Design Projects (CSCI420)](https://github.com/Lixxia/CSCI420)
[Operating Systems Projects (CSCI340)](https://github.com/Lixxia/CSCI340)

## C
Code that has been written during my Programming Language Concepts course.

## Ruby
Also written during my Programming Language Concepts class. See comments in code for explanations. 

## Java
### CSCI320/*
All of this code was written for my Data Structures and Algorithms course taken during the Fall 2012 semester. Most of it is well documented and named. 

Fair warning, this is old code. 

### WordCount.java
This was written during a course I took (Basics of Cloud Computing) while studying abroad at the University of Tartu.  We were tasked with using the Hadoop mapreduce project and modifying an example to serve as a word count. Given a folder containing several books in .txt format it would ignore the punctuation marks and go through each file separately producing a count of all the clear words. Finally we created a partioner class to direct all books whose file began with the same name to the same reduce task.

### PRG
This code was written for another course at UT, Cryptology I. I was given most of the code and tasked with modifying *Solution.java*. The code contains an implementation of a pseudo-random generator that transforms 16 bytes of randomness into 32 bytes of pseudo-randomness. Additionally, there is an implementation of a PRG G<sub>1</sub>(pseudo-random generator) that will transform 32 bytes into 48 bytes. Lastly there is an adversary that breaks G<sub>1</sub>. My assignment was to program an adversary **Solution.Adv_G_A** that breaks G by using the adversary A<sub>G<sub>1</sub></sub>. That adversary was also required to guess correctly with a probability > 0.95.

## Prolog
Self-explanatory. Also written for my Programming Language Concepts course.

## Python
### Practical 6 and 7
More code written for Basics of Cloud Computing. I was tasked with creating an application using Google AppEngine and doing the following:
- Adding a greeting utilizing the Google Users API
- Accessing Google Blob service to upload files
- Accessing uploaded files in the Google Blob store
- Creating a second Google App page
- Using the Google NDB Datastore service
- Displaying data from NDB Datastore
- Adding a file uploading to the messages

After completing these tasks the latest version of the application was deployed to the App Engine.
[Practical 6 Deliverable](https://lcbarber93.appspot.com/)
[Practical 7 Deliverable](http://lcbarber93.appspot.com/secondexercise)

### Hybrid.py
This was written for my Cryptology I class. I was told to implement a hybrid encryption using ElGamal and AES. Additionally I had to fix the functions **elgamal_encrypt** and **elgamal_decrypt** to avoid leaking whether the message **msg** is a quadratic residue.



