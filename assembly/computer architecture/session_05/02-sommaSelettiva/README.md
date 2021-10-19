# Somma selettiva

*nome del file sorgente: sommaSelettiva.asm*

Si scriva un programma che:
* chieda all’utente di inserire un array di interi di dimensione arbitraria. 
* invochi una procedura P 
* stampi il valore ritornato da P

La procedura P è definita come segue:
* Input: l’array inserito dall’utente e un parametro k
* se k=0 la procedura calcola la somma di tutti gli interi in posizione (indice nell’array) dispari
* se k=1 sommerà quelli in posizioni pari.

Suggerimento: allocare l’array staticamente in memoria e passare alla procedura il base address (passaggio per indirizzo).