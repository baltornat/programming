	# con direttiva di allineamento
	.data
	string1: .asciiz "Dammi un intero: "
	string2: .asciiz "I due numeri sono: "
	string3: .ascii ", "
	.align 2
	array: .space 8

	# senza direttiva di allineamento
	#.data
	#array: .space 8
	#string1: .asciiz "Dammi un intero: "
	#string2: .asciiz "I due numeri sono: "
	#string3: .asciiz ", "

	.text
	.globl main
main:
	li $v0, 4		# selezione print_string
	la $a0, string1		# $a0 = indirizzo di string1
	syscall			# lancio print_string

	li $v0, 5		# selezione di read_int
	syscall			# lancio read_int (in $v0)

	la $s1, array		# $s1 base address di array
	add $t0, $zero, $v0	# $t0 = $v0
	sw $t0, 0($s1)		# array[0] = $t0
	addi $t0, $t0, 1	# $t0 += 1
	sw $t0, 4($s1)		# array[1] = $t0

	li $v0, 4		# selezione di print_string
	la $a0, string2		# $a0 = indirizzo di string2
	syscall			# lancio print_string

	li $v0, 1		# selezione di print_int
	lw $t0, 0($s1)	
	move $a0, $t0		# $a0 = array[0]
	syscall			# lancio print_int

	li $v0, 4		# selezione di print_string
	la $a0, string3		# $a0 = indirizzo di string3
	syscall			# lancio print_string

	li $v0, 1		# selezione di print_int
	lw $t0, 4($s1)	
	move $a0, $t0		# $a0 = array[1]
	syscall			# lancio print_int

	li $v0, 10		# exit
	syscall
