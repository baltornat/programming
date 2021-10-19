; segment .data	 in data si mettono variabili inizializzate, che in questo esercizio non servono

extern scanf, printf, exit
global main
segment .text
main:
push x
push fmti
call scanf

push y
push fmti
call scanf

mov eax, [x]
add eax, [y]
push eax
push out
call printf

push 0
call exit

segment .bss	; bullshit, viene utilizzato per le variabili non inizializzate
; x: dd 0 non va bene perchè sto inizializzando uan double word con valore 0
; x: resd 1 reserve double word (riserva spazio per UNA double word)
; se avessi messo 2 avrebbe riservato spazio per 2 double word, x e x+4 (dimensione di una double word)

x: resd 1
y: resd 1

segment .rodata	; read-only data, ci si mette le stringhe di formato
fmti: db '%d',0	; lo 0 indica il carattere terminatore della stringa, il 10 è l'a-capo, fmti è il nome della strin
out: db 'La somma: %d',10,0
