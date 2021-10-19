segment .text
global main

main:
	mov ecx, msg		; stringa
	mov edx, msg_size	; dimensione stringa
	mov ebx, 1		; file descriptor (stdout)
	mov eax, 4		; syscall 4 (write)
	int 0x80

	mov eax, 1		; syscall 1 (exit)
	int 0x80

segment .rodata
msg: db 'Ciao solabbisti!',10,0
msg_size equ $ - msg
