segment	.text
global main

QUANTI equ 100
N equ QUANTI*2-2
main:	mov ax, 0xb800
		mov ds, ax
		mov cx, QUANTI
		mov bx, N
ciclo:	
		mov byte[ds:bx], 'm'
		sub bx, 2
		loop ciclo
fine:	hlt

times 510-($-$$)db 0
dw 0xAA55