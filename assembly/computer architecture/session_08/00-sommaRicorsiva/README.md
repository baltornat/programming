# Somma ricorsiva degli elementi in un array

*nome del file sorgente somma_ricorsiva.asm*

Si implementi una proceudura ricorsiva `S` che prenda in input un array e il numero di elementi di quell’array e restituisca la somma di tutti gli elementi dell’array. 
Si usi come riferimento il seguente codice sorgente C:

 ```c
int S( int arr[], int dim ) {
	if ( dim == 0 ) // caso base: array vuoto
		return 0 ;
	else // step ricorsivo
		return S( arr, dim - 1 ) + arr[ dim - 1 ] ;
}
```
