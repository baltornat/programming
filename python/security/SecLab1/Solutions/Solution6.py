#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr  1 16:14:34 2020

@author: marco

Esercizio #6 SecLab1:
    -Apply a brute force attack in order to recover the passwords plaintexts
"""

from functions import try_md5, try_sha1, try_sha224, try_sha256, try_sha384, try_sha512

with open("../06_short_password_cracking/hacked_passwords.txt", "r") as f:
    count = 1
    fl = f.readlines()
    for line in fl:
        s = line.split(':')[1]
        value_hash = ''.join(e for e in s if e.isalnum())
        l = len(value_hash)      
        if l == 32:
            print("Trying md5 to crack pwd for user",count,":")
            print("Password: " + try_md5(value_hash))
            print('\n')
        elif l == 40:
            print("Trying sha1 to crack pwd for user",count,":")
            print("Password: " + try_sha1(value_hash))
            print('\n')
        elif l == 56:
            print("Trying sha224 to crack pwd for user",count,":")
            print("Password: " + try_sha224(value_hash))
            print('\n')
        elif l == 64:
            print("Trying sha256 to crack pwd for user",count,":")
            print("Password: " + try_sha256(value_hash))
            print('\n')
        elif l == 96:
            print("Trying sha384 to crack pwd for user",count,":")
            print("Password: " + try_sha384(value_hash))
            print('\n')
        else:
            print("Trying sha512 to crack pwd for user",count,":")
            print("Password: " + try_sha512(value_hash))
            print('\n')
        count = count + 1
    


        