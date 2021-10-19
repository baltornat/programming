# Lettura e scrittura da memoria

*nome del file sorgente: rwmemoria2.asm*

Si scriva il codice Assembly che effettui:

		A[c-1] = c*(B[A[c]] + c)/A[2*c-1]

Inizializzazione dei registri indirizzi:
* i vettori A e B contengono 4 elementi, ogni elemento è un intero a 32 bit;

* la variabile c è intero a 32 bit.


Inizializzazione dei valori dati in memoria: 

		c=2
		A[0]=-1
		A[1]=-1
		A[2]= 1
		A[3]= 4
		B[0]=-1
		B[1]= 6
		B[2]=-1
		B[3]=-1

