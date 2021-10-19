segment	.text
global main

main:	mov dx, 420
		mov bx, 240
max:	cmp dx, bx
		je fine
		jg diff
		mov ax, dx
		mov dx, bx
		mov bx, ax
diff:	sub dx, bx
		jmp max
fine:	hlt

times 510-($-$$)db 0
dw 0xAA55