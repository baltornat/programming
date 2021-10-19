#include <stdio.h>

int main(void){
	int somma = 0;
	int n;
	do{
		printf("Inserisci un numero intero positivo: ");
		scanf("%d", &n);
		somma=somma+n;
	}while(n!=0);
	printf("La somma è: %d", somma);
	return 0;
}