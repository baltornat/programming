# INPUT:
# $a0 = base address dell'array
# $a1 = numero di elementi nell'array
# $a2 = elemento da cercare
# OUTPUT:
# $v0: 1 se elemento è trovato nell'array

	.text
	.globl belongs

belongs:
	li $v0, 0
loop:
	beq $a1, $zero, end
	lw $t0, 0($a0)
	beq $t0, $a2, found
	add $a0, $a0, 4
	sub $a1, $a1, 1
	j loop	
found:
	li $v0, 1
end:
	jr $ra