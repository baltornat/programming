# Codice sorgente prodotto in prima versione da Anton Kozhin (matr. 830515)

	.data
	string1: .asciiz "Inserisci numero di elementi: "
	string2: .asciiz "Inserisci elemento: "
	separatore: .asciiz " "
	.align 2
	array: .space 128

	# inverti array
	# -----------------
	# | a | b | c | d |
	# -----------------
	# -----------------
	# | d | c | b | a |
	# -----------------
	.text
	.globl main
main:

	# s0 = A[]
	# s1 = i
	# s2 = N

	li $v0, 4
	la $a0, string1
	syscall

	li $v0, 5
	syscall
	move $s2 ,$v0				# s2 <-- N input
	
	# input
	la $s0, array
	li $s1, 0				# s1 <-- i=0
	inizioCicloInput:
	beq $s1, $s2, fineCicloInput		# se i=N vai a fineCicloInput
		sll $t0, $s1, 2			# t0 <-- i*4
		add $t0, $s0, $t0		# t0 <--A[] + i*4

		li $v0, 4
		la $a0, string2
		syscall

		li $v0, 5
		syscall
		sw $v0, 0($t0)			# A[i] <-- elemento input
		addi $s1, $s1, 1		# i++
	j inizioCicloInput
	fineCicloInput:

	move $a0, $s0				# a0 <-- A[]
	li $a1, 0				# a1 <-- i=0
	add $a2, $s2, -1			# a2 <-- j=N-1
	jal stampaInverso

	li $v0, 10
	syscall

stampaInverso:

	#stampaInverso(A[], i, j)
	addi $sp, $sp, -16
	sw $ra, 12($sp)
	sw $s0, 8($sp)
	sw $s1, 4($sp)
	sw $s2, 0($sp)

	move $s0, $a0				# s0 <--A[]
	move $s1, $a1				# s1 <-- i
	move $s2, $a2				# s2 <-- j

	beq $s1, $s2, stampa			# if(i==N) vai a stampa
		addi $t0, $s1, 1		# i++
		# $a0 == &A[]
		move $a1, $t0			# a0 <-- i++
		# $a2 == N
		jal stampaInverso		# stampaInverso(A[], i, j)
	stampa:	
		# stampa A[i] e separatore
		sll $t0, $s1, 2			# t0 <-- i*4
		add $t0, $s0, $t0		# t0 <-- A[]+i*4 == &A[i]
		lw $a0, 0($t0)			# a0 <-- A[i]
		li $v0, 1
		syscall

		la $a0, separatore
		li $v0, 4
		syscall
		
	lw $s2, 0($sp)
	lw $s1, 4($sp)
	lw $s0, 8($sp)
	lw $ra, 12($sp)
	addi $sp, $sp, 16

	jr $ra
