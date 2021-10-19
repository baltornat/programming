#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr  1 19:33:16 2020

@author: marco
"""

import hashlib as h
import itertools

pool = "abcdefghijklmnopqrstuvwxyz"    #Item pool

def try_md5(value_hash):
    s = ""
    out = h.md5(s.encode()).hexdigest()
    if out == value_hash:
        return ""

    for item in itertools.product(pool, repeat=1):
        s = "".join(item)
        out = h.md5(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=2):
        s = "".join(item)
        out = h.md5(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=3):
        s = "".join(item)
        out = h.md5(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=4):
        s = "".join(item)
        out = h.md5(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=5):
        s = "".join(item)
        out = h.md5(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
        
        
def try_sha1(value_hash):
    s = ""
    out = h.sha1(s.encode()).hexdigest()
    if out == value_hash:
        return ""

    for item in itertools.product(pool, repeat=1):
        s = "".join(item)
        out = h.sha1(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=2):
        s = "".join(item)
        out = h.sha1(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=3):
        s = "".join(item)
        out = h.sha1(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=4):
        s = "".join(item)
        out = h.sha1(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=5):
        s = "".join(item)
        out = h.sha1(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
        
        
def try_sha224(value_hash):
    s = ""
    out = h.sha224(s.encode()).hexdigest()
    if out == value_hash:
        return ""
    
    for item in itertools.product(pool, repeat=1):
        s = "".join(item)
        out = h.sha224(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=2):
        s = "".join(item)
        out = h.sha224(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=3):
        s = "".join(item)
        out = h.sha224(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=4):
        s = "".join(item)
        out = h.sha224(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=5):
        s = "".join(item)
        out = h.sha224(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue



def try_sha256(value_hash):
    s = ""
    out = h.sha256(s.encode()).hexdigest()
    if out == value_hash:
        return ""
    
    for item in itertools.product(pool, repeat=1):
        s = "".join(item)
        out = h.sha256(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=2):
        s = "".join(item)
        out = h.sha256(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=3):
        s = "".join(item)
        out = h.sha256(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=4):
        s = "".join(item)
        out = h.sha256(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=5):
        s = "".join(item)
        out = h.sha256(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
        

def try_sha384(value_hash):
    s = ""
    out = h.sha384(s.encode()).hexdigest()
    if out == value_hash:
        return ""
    
    for item in itertools.product(pool, repeat=1):
        s = "".join(item)
        out = h.sha384(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=2):
        s = "".join(item)
        out = h.sha384(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=3):
        s = "".join(item)
        out = h.sha384(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=4):
        s = "".join(item)
        out = h.sha384(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=5):
        s = "".join(item)
        out = h.sha384(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue      
        
        
def try_sha512(value_hash):
    s = ""
    out = h.sha512(s.encode()).hexdigest()
    if out == value_hash:
        return ""

    for item in itertools.product(pool, repeat=1):
        s = "".join(item)
        out = h.sha512(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=2):
        s = "".join(item)
        out = h.sha512(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=3):
        s = "".join(item)
        out = h.sha512(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=4):
        s = "".join(item)
        out = h.sha512(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue
    for item in itertools.product(pool, repeat=5):
        s = "".join(item)
        out = h.sha512(s.encode()).hexdigest()
        if out == value_hash:
            return s
        else:
            continue

