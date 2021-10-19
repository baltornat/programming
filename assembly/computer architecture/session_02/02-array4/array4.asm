	.data
	A: .space 16		# Alloca 16 bytes per A

	.text
	.globl main

main:

	la $t0, A		# Scrive base address di A in $t0
	addi $t1, $zero, 0	# $t1 = 0
	sw $t1, 0($t0)		# A[0] = 0
	addi $t1, $zero, 4	# $t1 = 4
	addi $t0, $t0, 4	# indirizzo di A[1]
	sw $t1, 0($t0)		# A[1] = 4
	addi $t1, $zero, 8	# $t1 = 8
	addi $t0, $t0, 4	# indirizzo di A[2]
	sw $t1, 0($t0)		# A[2] = 8
	addi $t1, $zero, 12	# $t1 = 12
	addi $t0, $t0, 4	# indirizzo di A[3]
	sw $t1, 0($t0)		# A[3] = 12
