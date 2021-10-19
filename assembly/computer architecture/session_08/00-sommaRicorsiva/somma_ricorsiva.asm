	.text
	.globl S

S:    
	addi $sp, $sp, -8       # Salvo sullo stack $ra e dim-1
	addi $t0, $a1, -1       
	sw   $t0, 0($sp)
	sw   $ra, 4($sp)
		
	bne  $a1, $zero, CHIAMATA_RICORSIVA   	# branch ! ( size == 0 )

### CASO_BASE ###
	li   $v0, 0				# Caso base: se array vuoto ritorna 0
	addi $sp, $sp, 8        		# dealloco stack frame
	jr $ra
#################

### CHIAMATA_RICORSIVA ###
CHIAMATA_RICORSIVA:   
	move  $a1, $t0          	# aggiorno secondo argomento (il primo è il base addr. dell’array)
	jal   S
###########################

	# Ora in $v0 ho S(arr, dim-1)
		
	lw    $t0, 0($sp)       	# ripristino dim-1
	mul  $t1, $t0, 4        	# lo moltiplico per 4 e lo metto in $t1
	add   $t1, $t1, $a0     	# indirizzo di arr[dim-1]
	lw    $t2, 0($t1)       	# t2 = arr[dim-1]
	add   $v0, $v0, $t2     	# $v0 = S(arr, dim-1) + arr[dim-1]

	lw    $ra, 4($sp)       	# ripristino $ra      
	addi $sp, $sp, 8        	# dealloco stack frame
	jr $ra
