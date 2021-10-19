#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Mar 31 16:51:30 2020

@author: marco

Esercizio #1 SecLab1:
    -Decode the following text using Base64 algorithm
"""

ciphertext = "VGhpcyBpcyBiYXNlNjQgZW5jb2RpbmcsIGlzIG5vdCBhIGNoaXBlciBidXQgb25seSBhIHdheSB0byByZXByZXNlbnQgYmluYXJ5IGRhdGEgaW4gYW4gQVNDSUkgc3RyaW5nLg=="

print("Ciphertext: " + ciphertext + '\n')

conversion_table = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                    'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                    'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                    'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
                    '8', '9', '+', '/']

text = ""

for ch in ciphertext:                                                           #For each character in the ciphertext
    if ch == '=':
        text = text + "00"
    else:
        decimal_value = conversion_table.index(ch)                              #Returns the index of the character from the conversion table
        binary_value = bin(decimal_value)[2:]                                   #Returns the binary conversion of the decimal value
        while len(binary_value) != 6:               
            binary_value = '0' + binary_value                                   #Add 0 at the head as long as the length of the set of bits is != 6
        text = text + binary_value
        
n = int(text, 2)                                                                #Returns an integer object from a string; second parameter is the base of the string                       
print("Plaintext: " + n.to_bytes((n.bit_length() + 7) // 8, 'big').decode())    #Print the convertion from Byte to ASCII for each byte of the set of bits 

    

    

    


    

