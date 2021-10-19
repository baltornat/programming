# INPUT:
# $a0 = base address primo array
# $a1 = numero el primo array
# $a2 = base address secondo array
# $a3 = numero elementi secondo array
# OUTPUT:
# $v0: 1 se ogni elemento del primo array appartiene al secondo, 0 altrimenti

	.text
	.globl subseteq

subseteq:
	sub $sp, $sp, 20
	sw $ra, 16($sp)	
	sw $s0, 12($sp)
	sw $s1, 8($sp)
	sw $s2, 4($sp)
	sw $s3, 0($sp)

	move $s0, $a0
	move $s1, $a1
	move $s2, $a2
	move $s3, $a3

	li $v0, 1

loop:
	beq $s1, $zero, end

	move $a0, $s2
	move $a1, $s3
	lw $a2, 0($s0)
	jal belongs
	beq $v0, $zero, unsat
	
	add $s0 $s0, 4 	
	sub $s1, $s1, 1
	j loop

unsat:
	li $v0, 0

end:
	lw $ra, 16($sp)	
	lw $s0, 12($sp)
	lw $s1, 8($sp)
	lw $s2, 4($sp)
	lw $s3, 0($sp)
	add $sp, $sp, 20
	jr $ra
