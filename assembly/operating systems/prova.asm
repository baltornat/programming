extern scanf, printf, exit
global main
segment .text
main:

push imsg
call printf

push x
push ifmt
call scanf

push y
push ifmt
call scanf

mov eax, [x]
add eax, [y]
push eax

push ofmt
call printf

push 0
call exit

segment .rodata
imsg: db 'Inserisci due numeri interi: ',0
ifmt: db '%d',0
ofmt: db 'Somma: %d',10,0
segment .bss
x: resd 1	; reserve 1 double word
y: resd 1 	; reserve 1 double word
