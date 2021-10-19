# Binary search ricorsivo

*nome del file sorgente binarySearch.asm*

Si scriva un programma che esegua una binary search su un array ordinato di interi. Dato un array *A* di *N* interi ordinati e un intero *k*, la procedura *b(A,k,N)* restituisce 1 se *k* è contenuto in *A*. Restituisce 0 altrimenti.

Definizione operativa ricorsiva:

- *|A|*: numero di elementi in un array *|A|*;
- *e_i*: elemento di *A* in posizione *i*;
- *A^i_L*: array ottenuto selezionando da *A* gli elementi in posizione *j < i*;
- *A^i_R*: array ottenuto selezionando da *A* gli elementi in posizione *j > i*;

*b(A,k,N)=*

- *b(A^i_L, k, ceil(N/2)-1)*, se *k < e_{ceil(N/2)}*;
- *b(A^i_R, k, N-N/2)*, se *k > e_{ceil(N/2)}*;
- 1, se *k = e_{ceil(N/2)}*;
- 0, se *k <> e_{ceil(N/2)}* e *N=1*.

