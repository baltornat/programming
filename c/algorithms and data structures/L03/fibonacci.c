#include <stdio.h>

int fibonacci(int n){
	if(n<=2)
		return 1;
	else
		return fibonacci(n-1)+fibonacci(n-2);
}

int main(void){
	int n,ris;
	printf("Inserisci un numero: ");
	scanf("%d",&n);
	ris=fibonacci(n);
	printf("%d",ris);
	return 0;
}