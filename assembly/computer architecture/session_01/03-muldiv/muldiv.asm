	.text
	.globl main

main:

	addi $s1, $zero, 100	# s1 = 100
	addi $s2, $zero, 45	# s2 = 45

	mult $s1, $s2		# [Hi, Lo] = s1 * s2
	mflo $s0		# s0 = Lo

	move $s0, $zero		# Reset s0
	mul $s0, $s1, $s2	# s0 = s1 * s2

	move $s0, $zero		# Reset s0
	div $s1, $s2		# Hi = s1 % s2, Lo = s1 / s2
	mflo $s0		# s0 = Lo

	addi $s0, $zero, 0	# Reset s0
	div $s0, $s1, $s2	# s0 = s1 / s2