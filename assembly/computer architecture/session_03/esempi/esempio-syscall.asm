	.data
msg1: .asciiz "Hello world!"
msg2: .asciiz "Inserisci un intero"

	.text 
	.globl main
main:

	li $v0 4	# stampa su console
	la $a0, msg1
	syscall

	li $v0 55	# stampa messaggio in dialog
	la $a0 msg1
	li $a1 1
	syscall

	li $v0, 51	# acquisisci int in dialog
	la $a0, msg2
	syscall

	li $v0 10	# exit
	syscall
