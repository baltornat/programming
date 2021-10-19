#include <stdio.h>

void scambia(int *p,int *q){
	int aux;
	aux=*p;
	*p=*q;
	*q=aux;
}

int main(void){
	int p,q;
	printf("Inserisci P: ");
	scanf("%d",&p);
	printf("Inserisci Q: ");
	scanf("%d",&q);
	scambia(&p,&q);
	printf("P: %d, Q: %d\n",p,q);
	return 0;
}