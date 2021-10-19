.data

opt_str : .asciiz "\nOpzioni:\n(1) - Inserisci un elemento nello stack\n(2) - Rimuovi l'elemento in cima allo stack\n(3) - Stampa il contenuto dello stack\n(4) - Cerca un elemento\n(5) - Esci\n> "
x_str: .asciiz "X? "
y_str: .asciiz "Y? "
a_str: .asciiz "Angle? "

.text
.globl main

main:
	
loop:
	li $v0, 4
	la $a0, opt_str
	syscall		
	li $v0, 5
	syscall
	
	beq $v0, 1, L1
	beq $v0, 2, L2
	beq $v0, 3, L3
	beq $v0, 4, L4
	beq $v0, 5, L5
	
	j loop
	
L1:	li $v0, 4
	la $a0, x_str
	syscall
	li $v0, 5
	syscall
	move $t0, $v0
	li $v0, 4
	la $a0, y_str
	syscall
	li $v0, 5
	syscall
	move $t1, $v0
	li $v0, 4
	la $a0, a_str
	syscall
	li $v0, 5
	syscall
	move $t2, $v0
	move $a0, $t0
	move $a1, $t1
	move $a2, $t2
	jal stack_push
	
	j loop

L2:	jal stack_pop
	j loop

L3:	jal stack_print
	j loop
	
L4:	li $v0, 4
	la $a0, x_str
	syscall
	li $v0, 5
	syscall
	move $t0, $v0
	li $v0, 4
	la $a0, y_str
	syscall
	li $v0, 5
	syscall
	move $t1, $v0
	li $v0, 4
	la $a0, a_str
	syscall
	li $v0, 5
	syscall
	move $t2, $v0
	move $a0, $t0
	move $a1, $t1
	move $a2, $t2
	jal in_stack
	move $a0, $v0
	li $v0, 1
	syscall
	j loop

L5:	li $v0, 10		# exit()
	syscall
