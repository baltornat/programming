	.text
	.globl main

main:

	addi $s1, $zero, 1	# s1=1, B=1
	addi $s2, $zero, 2	# s2=2, C=2
	addi $s3, $zero, 3	# s3=3, D=3
	addi $s4, $zero, 4	# s4=4, E=4

	add $t0, $s1, $s2	# t0=s1+s2, t0=B+C
	add $t1, $s3, $s4	# t1=s3+s4, t1=D+E
	sub $s0, $t0, $t1	# s0=t0-t1, s0=(B+C)-(D+E)
