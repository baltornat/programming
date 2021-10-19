# Codice sorgente prodotto in prima versione da Anton Kozhin (matr. 830515)

	.data
	string1: .asciiz "Inserire N: "
	string2: .asciiz "Il fattoriale di N e': "
	string3: .asciiz "\nl' N-esimo numero di fibonacci e': "

	.text
	.globl main
main:

	li $v0, 4
	la $a0, string1
	syscall
	
	li $v0, 5
	syscall
	move $s0, $v0		# s0 <-- input N
	
	move $a0, $s0		# a0 <-- N
	jal fattoriale		# fattoriale(N)
	move $s1, $v0		# s1 <-- fattoriale(N)

	move $a0, $s0		# a0 <-- N
	jal fibonacci		# fibonacci(N)
	move $s2, $v0

	li $v0, 4
	la $a0, string2
	syscall

	li $v0, 1
	move $a0, $s1
	syscall

	li $v0, 4
	la $a0, string3
	syscall

	li $v0, 1
	move $a0, $s2
	syscall

	li $v0, 10
	syscall

fattoriale:

	addi $sp, $sp, -8
	sw $s0, 4($sp)
	sw $ra, 0($sp)
	
	move $s0, $a0			# s0 <-- N
	beq $s0, $zero, fattoriale_0	# if(N=0) vai a fattoriale0
	
		addi $t0, $s0, -1	# s1 <-- N-1
		move $a0, $t0		# a0 <-- N-1
		jal fattoriale		# fattoriale (N-1)
		mul $v0, $s0, $v0	# fattoriale = N * fattoriale(N-1)
		j return_fattoriale	# vai a return_fattoriale
	
	fattoriale_0:
		li $v0, 1		# return=1
	
	return_fattoriale:
		lw $ra, 0($sp)
		lw $s0, 4($sp)
		addi $sp, $sp, 8 
		jr $ra

fibonacci:

	addi $sp, $sp, -12
	sw $s0, 8($sp)
	sw $s1, 4($sp)
	sw $ra, 0($sp)
	
	move $s0, $a0				# s0 <-- N
		li $t0, 1
		beq $s0, $t0, fibonacci_1	# se N==1 vai a fibonacci_1
		li $t0, 2
		beq $s0, $t0, fibonacci_2	# se N==2 vai a fibonacci_2

		addi $s0, $s0, -1		# N=N-1

		move $a0, $s0
		jal fibonacci			# fibonacci(N-1)
		move $s1, $v0			# s1 <-- fibonacci(N-1
		
		addi $a0, $s0, -1		# N=N-2
		jal fibonacci			# fibonacci(N-2)
		add $v0, $s1, $v0		# v0 <-- fibonacci(N-1)+fibonacci(N-2)

		j return_fibonacci

	fibonacci_1:
		li $v0, 0			# return=0
		j return_fibonacci
	fibonacci_2:
		li $v0, 1			# return=1
	
	return_fibonacci:
		lw $ra, 0($sp)
		lw $s1, 4($sp)
		lw $s0, 8($sp)
		addi $sp, $sp, 12 
		jr $ra
