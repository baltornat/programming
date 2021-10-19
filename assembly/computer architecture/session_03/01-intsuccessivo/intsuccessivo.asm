	.data
	string1: .asciiz "Inserire numero intero: "	
	string2: .asciiz "L'intero successivo è: "

	.text
	.globl main

main:
	li $v0, 4		# selezione di print_string (codice = 4)
	la $a0, string1		# $a0 = indirizzo di string1
	syscall			# lancio print_string

	li $v0, 5		# Selezione read_int (codice = 5)
	syscall			# lancio read_int
	add $t0, $zero, $v0	# leggo risultato $t0 = $v0

	li $v0, 4		# selezione di print_string
	la $a0, string2		# $a0 = indirizzo di string2
	syscall			# lancio print_string

	addi $t0, $t0, 1	# $t0 += 1

	li $v0, 1		# selezione di print_int (codice = 1)
	add $a0,$zero,$t0	# $a0 = $t0
	syscall			# lancio print_int

	li $v0, 10		# exit
	syscall
