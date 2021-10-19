.data

stack :   .word 0   # Puntatore all'ultimo elemento inserito nello stack
stack_n : .word 0   # Nummero di elementi attualmente nello stack

x_str : .asciiz "X: "
y_str : .asciiz "Y: "
angle_str : .asciiz "Theta: "
empty_str : .asciiz "Stack is empty!\n"
nl : .asciiz "\n"
sep : .asciiz "-----------\n"

# Nodo di esempio:
# struct{
# 	int x;
# 	int y;
# 	int angle;
# 	int *next;
# }

.text

.globl stack_push
.globl stack_pop
.globl stack_print

# Input :
# a0 : x value
# a1 : y value
# a2 : angle value
# Output:
# ---------
stack_push:			# Inserisce un elemento nello stack
	move $t0, $a0
	move $t1, $a1
	move $t2, $a2

	la $t8, stack
	lw $t7, 0($t8)
	la $t9, stack_n

	li $a0, 16		# malloc(4*4 bytes)
	li $v0, 9
	syscall
	
	sw $t0, 0($v0)		# inizializza nuovo nodo
	sw $t1, 4($v0)
	sw $t2, 8($v0)
	sw $t7, 12($v0)		# next = *old_stack
	
	lw $t3, 0($t9)		# stack_n++
	addi $t3, $t3, 1	
	
	sw $v0, 0($t8)		# aggiorna lo stack pointer al nodo appena creato
	sw $t3, 0($t9)		# aggiorna il contatore di elementi
	
	jr $ra			# ritorna al chiamante

# Input:
# ---------
# Output :
# $v0 : address of popped element or 0 if stack is empty
stack_pop:

		la $t9, stack_n
		lw $t0, 0($t9)
		bne $t0, $zero, pop
		move $v0, $zero
		j pop_exit
	
pop:		la $t8, stack
		lw $v0, 0($t8)		# Vogliamo restituire l'indirizzo dell'elemento appena rimosso
	
		lw $t7, 12($v0)	
		subi $t0, $t0, 1	# stack_n--
	
		sw $t7, 0($t8)		# aggiorna lo stack pointer al nodo successivo a quello rimosso
		sw $t0, 0($t9)		# aggiorna il contatore di elementi
	
pop_exit:	jr $ra
	
# I/O : ---------------
stack_print:
	la $t8, stack
	la $t9, stack_n
	
	lw $t7, 0($t9)
	lw $t0, 0($t8)
	
	beq $t7, 0, empty_stack
	
print_loop:
	beq $t7, 0, end_loop
	
	# Stampa X
	li $v0, 4
	la $a0, x_str
	syscall
	li $v0, 1
	lw $a0, 0($t0)
	syscall
	li $v0, 4
	la $a0, nl
	syscall
	# Stampa Y
	li $v0, 4
	la $a0, y_str
	syscall
	li $v0, 1
	lw $a0, 4($t0)
	syscall
	li $v0, 4
	la $a0, nl
	syscall
	# Stampa Angolo
	li $v0, 4
	la $a0, angle_str
	syscall
	li $v0, 1
	lw $a0, 8($t0)
	syscall
	li $v0, 4
	la $a0, nl
	syscall
	# Stampa Separatore
	li $v0, 4
	la $a0, sep
	syscall
	
	lw $t0, 12($t0)			# Prossimo elemento
	subi $t7, $t7, 1		# Decrementa contatore
	
	j print_loop

empty_stack:
	li $v0, 4
	la $a0, empty_str
	syscall
	# Stampa Separatore
	li $v0, 4
	la $a0, sep
	syscall

end_loop:
	jr $ra	
