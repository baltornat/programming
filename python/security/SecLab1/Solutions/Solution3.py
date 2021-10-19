#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Mar 31 19:45:22 2020

@author: marco

Esercizio #3 SecLab1:
    -Recover the original plaintext using frequency analysis and the encryption key
"""

file = open("../03_monoalphabetic_chiper/ciphertext.txt", "r")                  #Read the ciphertext
if file.mode == 'r':
    ciphertext = file.read()
file.close()

print("Ciphertext: ")
print(ciphertext)

counts = {}
for ch in ciphertext:                                                           #Frequence
    if ch != ' ' and ch != '\n' and ch != ',' and ch != ';':                    #Exclude ' ', '\n', ',', ';'
        if ch in counts:
            counts[ch] += 1
        else:
            counts[ch] = 1

print("Frequences: ")
print(counts)

plaintext = ""
for ch in ciphertext:
    if ch == 'j':
        plaintext = plaintext + 'A'
    elif ch == 'n':
        plaintext = plaintext + 'E'
    elif ch == 'r':
        plaintext = plaintext + 'I'
    elif ch == 'u':
        plaintext = plaintext + 'L'
    elif ch == 'd':
        plaintext = plaintext + 'R'
    elif ch == 'b':
        plaintext = plaintext + 'P'
    elif ch == 'f':
        plaintext = plaintext + 'T'
    elif ch == 'k':
        plaintext = plaintext + 'B'
    elif ch == 'g':
        plaintext = plaintext + 'U'
    elif ch == 'l':
        plaintext = plaintext + 'C'
    elif ch == 'm':
        plaintext = plaintext + 'D'
    elif ch == 'a':
        plaintext = plaintext + 'S'
    elif ch == 'e':
        plaintext = plaintext + 'O'
    elif ch == 'z':
        plaintext = plaintext + 'N'
    elif ch == 'i':
        plaintext = plaintext + 'Z'
    elif ch == 'h':
        plaintext = plaintext + 'V'
    elif ch == 'v':
        plaintext = plaintext + 'M'
    elif ch == 'p':
        plaintext = plaintext + 'G'
    elif ch == 'o':
        plaintext = plaintext + 'F'
    elif ch == 'c':
        plaintext = plaintext + 'Q'
    elif ch == 'q':
        plaintext = plaintext + 'H'
    else:
        plaintext = plaintext + ch

print("\nPlaintext: ")
print(plaintext)
