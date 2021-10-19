	.data
	string1: .asciiz "Numero di interi (N): "
	string2: .asciiz "Prossimo intero (ordine crescente)"
	string3: .asciiz "Gli interi devono essere in ordine crescente."
	string4: .asciiz "Intero da cercare:"
	string5: .asciiz "Trovato."
	string6: .asciiz "Non trovato."
	.align 2
	array: .space 512

	.text
	.globl main
main:

	# stampa "Numero di interi (N): "
	li $v0, 4
	la $a0, string1
	syscall

	# leggi N 
	li $v0, 5
	syscall
	move $s2 ,$v0		# $s2 <- N	
	la $s0, array		# $s0 <- A[]
	li $s1, 0		# $s1 <- i=0 (array index)
	
	
	# riempimento ordinato dell'array
loop:
	beq $s1, $s2, end_loop		# se ho inserito N elementi, termina loop di inserimento

	sll $t0, $s1, 2 		# $t0 <- i*4
	add $t0, $s0, $t0 		# $t0 <- indirizzo a cui inserire il prossimo intero

read_element:
	# stampa "Prossimo intero (ordine crescente)"
	li $v0, 4
	la $a0, string2
	syscall

	# leggi prossimo intero
	li $v0, 5
	syscall
	move $t2, $v0
		
	beq $s1, 0, insert_ok	# se è il primo inserimento, non devo controllare ordine crescente
		
	# controllo che il numero inserito sia >= del precedente (ordine crescente)
	slt $t3, $t2, $t1
	bne $t3, 1, insert_ok
		
	# se l'intero non rispetta l'ordine:
	# stampa "Gli interi devono essere in ordine crescente."
	li $v0, 4
	la $a0, string3
	syscall
	# richedi l'intero
	j read_element
		
insert_ok:
	sw $t2, 0($t0)		# A[i] <- intero letto
	move $t1, $t2		# $t1 <- A[i] (aggiorno ultimo elemento inserito)
	addi $s1, $s1, 1	# $s1 <- i++
		
	j loop
		
end_loop:
	
	# stampa "Intero da cercare:"
	li $v0, 4
	la $a0, string4
	syscall

	# leggo intero da cercae (k)
	li $v0, 5
	syscall
		
	#	chiamata a binary_search:
	# $a0 <- A[]
	# $a1 <- N
	# $a2 <- k
	move $a0 ,$s0
	addi $a1, $s2, 0
	move $a2, $v0
	
	jal binary_search
	
	# exit
	li $v0, 10
	syscall	
		
	
########################################################
# procedura binary_search:
# INPUT:
# 	$a0 <- A[]
# 	$a1 <- N
# 	$a2 <- k
# OUTPUT: stampa "Trovato" se k è in A, "Non trovato" altrimenti
########################################################

binary_search:

	# calcolo l'indice dell'elemento a metà dell'array (pivot, p)
	li $t0, 2
	div $a1, $t0
	mflo $t0		# $t0 <- p = floor(N/2)
	
	# leggo l'elemento A[p] (indirizzo in $t1)
	sll $t1, $t0, 2
	add $t1, $t1, $a0
	lw $t2, 0($t1)
	
	# se l'array contiene un solo elemento (N=1)
	# allora terminerò di sicuro (trovato o non trovato)
	bne $a1, 1, check_before_step	
	
	# controllo se l'elemento letto (A[p]) è quello che cerco 
	# se sì: bs_found e termina
	# se no: bs_not_found
	bne $a2, $t2, bs_not_found
		
bs_found:
	# stampa "Trovato." e termina
	li $v0, 4
	la $a0, string5
	syscall
	jr $ra	
	
	# N > 1
	# prima controllo se l'emenento pivot è quello che cerco,
	# se lo è bs_found e termina
check_before_step:
	beq $a2, $t2, bs_found 

	# se non lo è, devo fare lo step ricorsivo
	# (cerco nel sotto-array sinistro o destro 
	# quando k < A[p] o  k < A[p] rispettivamente	
	
rec_step:
	# salvo return address
	addi $sp, $sp, -4
	sw $ra, 0($sp)
		
	slt $t3, $a2, $t2 
	bne $t3,1, bs_right_half		# se k >= A[p] cerca nella metà destra
		
	# altrimenti cerca nella metà di sinistra
	move $a1, $t0				# il numero di elementi è uguale a p (l'array che considero va da indice 0 a p-1)
	jal binary_search
	j end		
		
	# cerca nella metà di destra
bs_right_half:
	addi $a0, $t1, 4		# sposto in avanti in base address
	sub $a1, $a1, $t0		# aggiorno il numero di elementi (che si è ridotto)
	jal binary_search
		
	# ripristina $ra e chiudi
end:
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	jr $ra
		
bs_not_found:
	# stampa "Non trovato." e termina
	li $v0, 4
	la $a0, string6
	syscall
	jr $ra
