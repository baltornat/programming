#include <stdio.h>

int main(void){
	float somma = 0;
	int cont = 0;
	int n;
	do{
		printf("Inserisci un numero intero positivo: ");
		scanf("%d", &n);
		somma=somma+n;
		if(n!=0)
			cont++;
	}while(n!=0);
	printf("La media è: %f", somma/cont);
	return 0;
}