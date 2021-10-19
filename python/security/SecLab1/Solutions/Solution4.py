#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr  1 14:37:29 2020

@author: marco

Esercizio #4 SecLab1:
    -Check the integrity of the PDF file 
"""

import hashlib as h

#MD5

file = open("../04_integrity_checks/checksum.md5", "r")                  #Read the ciphertext
if file.mode == 'r':
    check_md5 = file.read()
file.close()

with open('../04_integrity_checks/PE_Format_Walkthrough.pdf', 'rb') as f:
    h1 = h.md5(f.read()).hexdigest()
    
if h1 == check_md5:
    print("MD5: correct")
else:
    print("MD5: incorrect")

#SHA1

file = open("../04_integrity_checks/checksum.sha1", "r")                  #Read the ciphertext
if file.mode == 'r':
    check_sha1 = file.read()
file.close()

with open('../04_integrity_checks/PE_Format_Walkthrough.pdf', 'rb') as f:
    h1 = h.sha1(f.read()).hexdigest()
if h1 == check_sha1:
    print("SHA1: correct")
else:
    print("SHA1: incorrect")
    
#SHA256

file = open("../04_integrity_checks/checksum.sha256", "r")                  #Read the ciphertext
if file.mode == 'r':
    check_sha256 = file.read()
file.close()

with open('../04_integrity_checks/PE_Format_Walkthrough.pdf', 'rb') as f:
    h1 = h.sha256(f.read()).hexdigest()
if h1 == check_sha256:
    print("SHA256: correct")
else:
    print("SHA256: incorrect")
    
#SHA512

file = open("../04_integrity_checks/checksum.sha512", "r")                  #Read the ciphertext
if file.mode == 'r':
    check_sha512 = file.read()
file.close()

with open('../04_integrity_checks/PE_Format_Walkthrough.pdf', 'rb') as f:
    h1 = h.sha512(f.read()).hexdigest()
if h1 == check_sha512:
    print("SHA512: correct")
else:
    print("SHA512: incorrect")