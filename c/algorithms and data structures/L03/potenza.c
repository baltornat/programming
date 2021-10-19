#include <stdio.h>

int potenza(int b, int e){
	int ris=1,cont=0;
	if(e==0)
		return 1;
	do{
		ris=ris*b;
		cont++;
	}while(cont<e);
	return ris;
}

int main(void){
	int b,e,ris;
	printf("Inserisci la base e l'esponente: ");
	scanf("%d,%d",&b,&e);
	ris=potenza(b,e);
	printf("Risultato: %d",ris);
	return 0;
}