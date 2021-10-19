	.data
	A: .space 52
	h: .space 4

	.text
	.globl main

main:

	la $s1, h 		# $t0 = &h
	la $s2, A 		# $t1 = A
	lw $t0, 0($s1)		# $t0 = h
	lw $t1, 32($s2)		# $t1 = A[8]
	add $t0, $t1, $t0 	# $t0 = $t1 + $t0
	sw $t0, 48($s2) 	# A[12] = $t0