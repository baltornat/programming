#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr  1 15:22:20 2020

@author: marco

Esercizio #5 SecLab1:
    -Provide the value of 'i'
"""

import random
import hashlib as h

pool = b'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'    #Item pool
out = ""

while out[:5] != "00000":                                                   #Execute as long as the first 5 characters of the output isn't like 00000xxxxxxxxxxxxxxxx
    s = bytearray()
    for i in range(20):                                                     #Execute 20 times because 20*8(bit) = 160 bit (sha1 length)
        s.append(random.choice(pool))                                       #Choose randomly one character from the pool and put it in the input
    out = h.sha1(s).hexdigest()                                             #Apply sha1 on the input, repeat if the first 5 characters aren't like 00000xxxxxxxxxxxxxxxx
print("Value found: ")
print(s.decode("utf-8"))

