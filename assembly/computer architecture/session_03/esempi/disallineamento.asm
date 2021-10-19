	.data
string: 	.asciiz "Ciao" # stringa lunga 4 byte più carattere di fine stringa
	.align 2 # se non includessi questa direttiva, A verrebbe allocato ad un indirizzo non multiplo di 4
A: 	.byte 2,0,0,0,4,0,0,0
	
	.text
	.globl main
main:

	la $t0, A
	li $t1, 5
	sw $t1 0($t0)
