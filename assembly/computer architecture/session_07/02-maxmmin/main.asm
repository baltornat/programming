	.data
A: 	.word 2234,227,224,226,14,17,112,16 # matrice A
dimA: 	.word 2,4 # dimensione di A (righe, colonne)

	.text
	.globl main

main:
	la $t0, dimA

	la $a0, A	# base address matrice
	lw $a1, 0($t0) # num. righe
	lw $a2, 4($t0) # num. colonne
	#li $a3, 1 #maxmin
	li $a3, 0 #minmax
	jal maxmin_minmax
	
	# print int
	move $a0, $v0
	li $v0, 1
	syscall
	
	# exit
	li $v0, 10
	syscall
