	.data
	v: .byte 2,0,0,0,4,0,0,0
	array: .byte 2,0,0,0,3,0,0,0,5,0,0,0,7,0,0,0,11,0,0,0,13,0,0,0,17,0,0,0,19,0,0,0


	.text
	.globl main

main:
	la $s1, array
	la $s2, v

	lw $t0, 0($s2)
	addi $t0, $t0, -1
	mul $t0, $t0, 4
	add $t1, $s1, $t0
	lw $t2, 0($t1)
	addi $t2, $t2, 1

	lw $t0, 4($s2)
	addi $t0, $t0, -1
	mul $t0, $t0, 4
	add $t3, $s1, $t0
	lw $t4, 0($t3)
	addi $t4, $t4, -1

	sw $t2, 0($t3)
	sw $t4, 0($t1)

	jr $ra
