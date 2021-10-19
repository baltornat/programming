segment	.text
global main

main:
MOV AH, 0Eh

MOV AL, 'C'
INT 10h
MOV AL, 'i'
INT 10H
MOV AL, 'a'
INT 10H
MOV AL, 'o'
INT 10H
MOV AL, ' '
INT 10H
MOV AL, 'A'
INT 10H
MOV AL, 'l'
INT 10H
MOV AL, 'b'
INT 10H
MOV AL, 'e'
INT 10H
MOV AL, 'r'
INT 10H
MOV AL, 't'
INT 10H
MOV AL, 'o'
INT 10H
MOV AL, '!'
INT 10H
fine:	hlt

times 510-($-$$)db 0
dw 0xAA55
