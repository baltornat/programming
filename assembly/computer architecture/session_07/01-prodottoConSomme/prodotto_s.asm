# INPUT:
# $a0 e $a1 due interi positivi
# OUTPUT:
# il loro prodotto ottenuto con somme

	.text
	.globl prodotto_s

prodotto_s:
	sub $sp, $sp, 16
	sw $ra, 8($sp)
	sw $s0, 4($sp)
	sw $s1, 0($sp)
	sw $s2, 0($sp)

	move $s0, $a0
	move $s1, $a1

	blt $s0, $s1, sums
	move $t0, $s0
	move $s0, $s1
	move $s1, $t0
	li $s2, 0

sums:
	beq $s0, $zero, end
	
	move $a0, $s2
	move $a1, $s1
	jal somma
	move $s2, $v0	

	sub $s0, $s0, 1
	j sums

end:
	move $v0, $s2

	lw $ra, 8($sp)
	lw $s0, 4($sp)
	lw $s1, 0($sp)
	lw $s2, 0($sp)
	add $sp, $sp, 16

	jr $ra
