	.data
	A: .space 16 	# vettore con 4 elementi
	B: .space 16 	# vettore con 4 elementi
	c: .space 4 	# vettore con 4 elementi

	.text
	.globl main

main: 
	# Inizializzazione registri indirizzi
	la $s0, A
	la $s1, B
	la $s2, c

	# Inizializzazione valori (c=2)
	addi $t0, $zero, 2	# $t0=2
	sw $t0, 0($s2)		# c=$t0

	# Inizializzazione vettori A e B
	addi $t0, $zero, -1	# $t0 = -1
	sw $t0, 0($s0)		# A[0] = -1
	sw $t0, 4($s0)		# A[1] = -1
	sw $t0, 0($s1)		# B[0] = -1
	sw $t0, 8($s1)		# B[2] = -1
	sw $t0, 12($s1)		# B[3] = -1
	addi $t0, $zero, 1	# $t0 = 1
	sw $t0, 8($s0)		# A[2] = 1
	addi $t0, $zero, 4	# $t0 = 4
	sw $t0, 12($s0)		# A[3] = 1
	addi $t0, $zero, 6	# $t0 = 6
	sw $t0, 4($s1)		# B[1] = 1

	# calcolo A[c-1] = c*(B[A[c]] + c)/A[2*c-1]
	lw $t0, 0($s2)		# $t0 = c
	addi $t1, $zero, 4	# $t1 = 4
	mult $t0, $t1		# lo = $t0 * $t1 = c * 4
	mflo $t2		# $t2=c*4, offset di A[c]
	add $t2, $s0, $t2 	# $t2 = $s0+$t2, indirizzo di A[c]
	lw $t3, 0($t2)		# $t3 = A[c]
	mult $t1, $t3		# lo = 4 * A[c]
	mflo $t3		# $t3=4 * A[c], offset di B[A[c]]
	add $t3, $s1, $t3	# $t3 = $s1+$t3, indirizzo di B[A[c]]
	lw $t2, 0($t3)		# $t2 = B[A[c]]
	add $t2, $t0, $t2	# $t2 = B[A[c]] + c
	mult $t0, $t2		# lo = c * (B[A[c]] + c)
	mflo $t2		# $t2 = c * (B[A[c]] + c)
	addi $t3, $zero, 2	# $t3 = 2
	mult $t0, $t3		# lo = 2 * c
	mflo $t3		# $t3 = 2 * c
	addi $t3, $t3, -1	# $t3 = 2 * c - 1
	mult $t1, $t3		# lo = 4 * (2 * c - 1)
	mflo $t3		# $t3 = 4 * (2 * c - 1), offset di A[2*c-1]
	add $t3, $s0, $t3	# $t3 = $s1+$t3, indirizzo di A[2*c-1]
	addi $t0, $t0, -1	# $t0 = c -1
	mult $t0, $t1		# lo = (c-1) * 4
	mflo $t0		# $t0=(c-1) * 4, offset di A[c-1]
	add $t1, $s0, $t0 	# $t1 = $s0+$t0, indirizzo di A[c-1]
	lw $t0, 0($t3)		# $t0 = A[2*c-1]
	div $t2, $t0		# lo = c*(B[A[c]] + c)/A[2*c-1]
	mflo $t2		# $t2 = c*(B[A[c]] + c)/A[2*c-1]
	sw $t2,0($t1)		# A[c-1] = c*(B[A[c]] + c)/A[2*c-1]
