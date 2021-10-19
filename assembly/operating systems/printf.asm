segment .text
global main
extern printf, exit		; libreria printf

main:	
	mov eax, 24
	add eax, 42
	mov [x], eax

	push dword [x]
	push fmt
	call printf

	push 0
	call exit

segment .data
x: dd 0

segment .rodata
fmt: db 'Risultato: %d',10,0 
