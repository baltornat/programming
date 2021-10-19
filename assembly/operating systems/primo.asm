segment .text ; segmento "testo" (istruzioni)
global main ; nome convenzionale

main:	mov eax, 24
	add eax, 42
	mov[x], eax
	
	mov ebx, 0xb8000
	mov ds, ebx
	mov byte [10], 'm' ; indirizzamento relativo a ds	
segment .data	; segmento dati
x: dd 0 ; pseudo istruzione: double word (4 byte) 
