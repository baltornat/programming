#include <stdio.h>

int primo(int n){
	int i;
	for(i=2;i<n;i++){
		if((n%i)==0){
			return 1;
		}
	}
	return 0;
}

int main(void){
	int n,ris;
	printf("Inserisci un numero intero: ");
	scanf("%d",&n);
	ris=primo(n);
	if(ris==0)
		printf("Il numero è primo");
	else
		printf("Il numero non è primo");
	return 0;
}