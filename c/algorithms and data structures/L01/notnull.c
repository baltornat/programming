#include <stdio.h>

int main(void){
	int somma = 0;
	int n;
	int i;
	for(i=0;i<10;i++){
		printf("Inserisci il numero %d: ",i+1);
		scanf("%d", &n);
		if(n==0)
			break;
		somma+=n;
	}
	printf("La somma è: %d",somma);
	return 0;
}