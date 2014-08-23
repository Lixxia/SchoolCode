#!/usr/bin/python

# Tested with Python 2.7

# install pycrypto using "pip install pycrypto"

import Crypto.PublicKey.ElGamal
import Crypto.Random
import Crypto.Random.random
from Crypto.Cipher import AES

# Not a recommended keylen. But quicker for experimenting.
elgamal_keylen = 512

def bytes_to_int(byts):
    """Converts a bitstring (given as a bytes/str object) into an integer"""
    i = 0
    for b in byts:
        i *= 256
        i += ord(b)
    return i

def int_to_bytes(i,numbytes):
    """Converts an integer back to an bytes/str object.
    numbytes is the desired length of the bytes/str object.

    It holds: int_to_bytes(bytes_to_int(m),len(m))==m
    """
    assert i>=0
    b = [0 for _ in range(numbytes)]
    for idx in range(numbytes):
        b[numbytes-idx-1] = chr(i&0xFF)
        i = i>>8
    assert i==0, "Integer did not fit in {} bytes".format(numbytes)
    return b''.join(b)

# Test:
m = "This is a test!"
assert int_to_bytes(bytes_to_int(m),len(m))==m

random = Crypto.Random.new()

def elgamal_keygen():
    """Returns an ElGamal key pair (pk,sk).
    Call as "(pk,sk) = elgamal_keygen()".
    """
    sk = Crypto.PublicKey.ElGamal.generate(elgamal_keylen, random.read)
    pk = sk.publickey()
    return (pk,sk)

def elgamal_encrypt(pk,msg):
    """Raw ElGamal encryption.
    msg must satisfy 0<=msg<pk.p"""
    assert isinstance(msg,(int,long)), "Message must be an integer"
    assert 0<=msg<pk.p, "Message must satisfy 0<=msg<p"
    k = Crypto.Random.random.StrongRandom().randint(1,pk.p-1)
    return pk.encrypt(msg,k)

def elgamal_decrypt(sk,c):
    """Raw ElGamal decryption."""
    return sk.decrypt(c)

def aes_keygen():
    """Returns a 32 bytes AES key"""
    return Crypto.Random.new().read(256/8)

def aes_encrypt(k,msg):
    """Encrypts with AES, CBC-mode. Not IND-CCA secure.
    Message length must be a multiple of 16."""
    assert isinstance(k,(str,bytes)), "Key must be a string/byte sequence"
    assert isinstance(msg,(str,bytes)), "Msg must be a string/byte sequence"
    iv = Crypto.Random.new().read(AES.block_size)
    cipher = AES.new(k,AES.MODE_CBC,iv)
    return iv+cipher.encrypt(msg)


def aes_decrypt(k,c):
    """Decrypt with AES. (Probably not IND-CCA secure)"""
    assert isinstance(k,(str,bytes)), "Key must be a string/byte sequence"
    assert isinstance(c,(str,bytes)), "Ciphertext must be a string/byte sequence"
    iv = c[:16]
    cipher = AES.new(k,AES.MODE_CBC,iv)
    return cipher.decrypt(c[16:])


### Just for demo & testing:
##k = aes_keygen()
##msg = "Hello world... !"
##c = aes_encrypt(k,msg)
##msg2 = aes_decrypt(k,c)
##print "Result of decrypting with AES:",msg2
##assert msg==msg2, "AES encryption did not decrypt correctly"


### Just for demo & testing:
##(pk,sk) = elgamal_keygen()
##msg = 1234567L
##c = elgamal_encrypt(pk,msg)
##msg2 = elgamal_decrypt(sk,c)
##print "Result of decrypting with ElGamal:", msg2
##assert msg==msg2, "ElGamal encryption did not decrypt correctly"


def hybrid_keygen():
    (pk,sk) = elgamal_keygen()
    return (pk,sk)

def hybrid_encrypt(pk,msg):
    key = aes_keygen()
    k = bytes_to_int(key)
    c1 = elgamal_encrypt(pk,k)
    c2 = aes_encrypt(key,msg)
    return (c1,c2)

def hybrid_decrypt(sk,c):
    c1, c2 = c
    k = elgamal_decrypt(sk, c1)
    k2 = int_to_bytes(k,32)
    m = aes_decrypt(k2,c2)
    return m


# Just for demo & testing:
(pk,sk) = elgamal_keygen()
msg = "Hello world!"
c = hybrid_encrypt(pk,msg)
msg2 = hybrid_decrypt(sk,c)
print "Result of decrypting with hybrid encryption:", msg2
assert msg==msg2, "Hybrid encryption did not decrypt correctly"
