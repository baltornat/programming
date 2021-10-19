#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Mar 31 18:38:27 2020

@author: marco

Esercizio #2 SecLab1:
    -Recover the original plaintext
"""

file = open("../02_stream_chiper/crypt.txt", "r")   #Read the ciphertext
if file.mode == 'r':
    ciphertext = file.read()
file.close()

file = open("../02_stream_chiper/key.txt", "r")     #Read the key
if file.mode == 'r':
    key = file.read()
file.close()
    
print("Key: " + key + '\n')
print("Ciphertext: " + ciphertext + '\n')

"""
Returns the binary convertion of text
 -ord() -> returns decimal value of the character received by input
 -bin() -> returns binary convertion of the integer received by input
"""
def convert_to_binary(text):
    binary_text = ""
    for ch in text:
        binary = bin(ord(ch))[2:]
        while len(binary) != 8:                                                 #If the length of the set of bits is != 8 add zeroes 
            binary = '0' + binary 
        binary_text = binary_text + binary    
    binary_text = "0b" + binary_text 
    return binary_text

binary_ciphertext = convert_to_binary(ciphertext)
binary_key = convert_to_binary(key)

n = (int(binary_ciphertext, 2) ^ int(binary_key, 2))                            #Do the bitwise XOR between the ciphertext and the key

print("Plaintext: " + n.to_bytes((n.bit_length() + 7) // 8, 'big').decode())    #Print the convertion from Byte to ASCII for each byte of the set of bits  
