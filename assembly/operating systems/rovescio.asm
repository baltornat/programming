extern scanf, printf, exit, malloc
global main
segment .text
main:
	push imsg1
	call printf

	push n
	push ifmt
	call scanf

	push dword [n]
	push imsg2
	call printf

	mov eax, 4
	mul dword [n]			; moltiplica eax *4 (sizeof double word)
	push dword eax
	call malloc
	mov dword [p], eax		; indirizzo base della malloc
	
	mov ecx, [n]			; contatore = al numero di elementi
read:
	cmp ecx, 0
	jz wloop

	mov eax, 4
	sub ecx, 1
	mul ecx
	add eax, [p]
	
	push ecx			; salvo prima della scanf

	push eax			; base + offset
	push ifmt
	call scanf			; inserimento

	add esp, 8			; salto ifmt e eax salvati sullo stack 2*4
	pop ecx				; ottengo ecx

	jmp read
wloop:
	mov eax, [n]
	sub eax, 1
	mov dword [n]
	cmp ecx, dword [n]
	jz end

	mov eax, 4
	sub ecx, 1
	mul ecx
	add eax, [p]

	push eax
	push ofmt 
	call printf 
	add esp, 8
	pop ecx
end:	
	push 0
	call exit
segment .rodata
	imsg1: db 'Inserisci il numero di elementi: ',0
	imsg2: db 'Inserisci i %d elementi: ',0
	ifmt: db '%d',0
	ofmt: db ' %d ',0
segment .bss
	n: resd 1
	p: resd 1
