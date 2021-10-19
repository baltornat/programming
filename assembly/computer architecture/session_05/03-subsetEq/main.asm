	.data
	.align 2
arr1:	.byte 1, 0, 0, 0,  2, 0, 0, 0,  4, 0, 0, 0
l1:	.byte 3, 0, 0, 0
arr2:	.byte 1, 0, 0, 0,  5, 0, 0, 0,  2, 0, 0, 0,  12, 0, 0, 0,  3, 0, 0, 0
l2:	.byte 5, 0, 0, 0
s1:	.asciiz "Condizione soddisfatta"
s2:	.asciiz "Condizione non soddisfatta"


	.text
	.globl main

main:
	# push sullo stack di $ra
	sub $sp, $sp, 4
	sw $ra, 0($sp)

	la $t0, l1
	lw $t0, 0($t0) 

	la $t1, l2
	lw $t1, 0($t1)

	la $a0, arr1
	move $a1, $t0
	la $a2, arr2
	move $a3, $t1
	jal subseteq

	beq $v0, $zero, unsat

	li $v0, 4
	la $a0, s1
	syscall

	j end
unsat:

	li $v0, 4
	la $a0, s2
	syscall
end:
	lw $ra, 0($sp)
	add $sp, $sp, 4
	
	li $v0, 10
	syscall
