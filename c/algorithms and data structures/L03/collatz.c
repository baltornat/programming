#include <stdio.h>

int collatz(int n){
	if(n%2==0)
		return n/2;
	else
		return (n*3)+1;
}

int main(void){
	int n;
	printf("Inserisci un numero: ");
	scanf("%d",&n);
	do{
		n=collatz(n);
		printf("%d ",n);
	}while(n!=1);
	return 0;
}