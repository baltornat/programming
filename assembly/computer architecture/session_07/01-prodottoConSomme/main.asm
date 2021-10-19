	.text
	.globl main
	.globl prodotto_s

main:
	# push sullo stack di $ra
	sub $sp, $sp, 4
	sw $ra, 0($sp)

	# leggo primo intero
	li $v0, 5
	syscall
	move $s0, $v0

	# leggo secondo intero
	li $v0, 5
	syscall
	move $s1, $v0

	li $s2, 0
	
	# calcolo il segno del risultato
	blt $s0, $zero, neg1
	blt $s1, $zero, isneg
	j multiply
neg1:
	bge $s1, $zero, isneg
	j multiply
isneg:
	li $s2, 1

	# moltiplico in valore assoluto
multiply:
	abs $a0, $s0
	abs $a1, $s1
	jal prodotto_s
	move $t0, $v0

	# aggiusto il segno
	bne $s2, 1, pos
	neg $t0, $t0	
pos:
	# stampo il risultato
	li $v0, 1
	move $a0, $t0
	syscall

	lw $ra, 0($sp)
	add $sp, $sp, 4
	jr $ra
