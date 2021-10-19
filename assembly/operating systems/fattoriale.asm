extern scanf, printf, exit

global main
segment .text
fattoriale:
	push ebp
	mov ebp, esp		; salvo lo stack pointer
	
	mov eax, [ebp+8]	; carico il valore in eax
	cmp eax, 1
	jz end
	
	mov ecx, [ebp+8]
	sub ecx, 1
	push dword ecx		;pusho n-1
	call fattoriale		;richiamo la funzione
	mul dword [ebp+8]

end:
	mov esp, ebp		; ripristino lo stack pointer
	pop ebp
	ret

main:
	push x
	push in
	call scanf		; leggo input

	push dword [x]
	call fattoriale		; chiamo la funzione fattoriale sul numero letto in input

	push dword eax
	push out
	call printf

	push 0
	call exit

segment .bss
	x: resd 1

segment .rodata
	in: db ' %d',0
	out: db 'Fattoriale: %d',10,0

