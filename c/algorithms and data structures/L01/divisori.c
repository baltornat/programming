#include <stdio.h>

int main(void){
	int n,i,cont=0;
	printf("Inserisci un numero intero: ");
	scanf("%d", &n);
	for(i=1;i<=n;i++){
		if((n%i)==0){
			cont++;
			printf("%d: %d\n",cont,i);
		}
	}
	return 0;
}