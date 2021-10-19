#include <stdio.h>

int main(void){
	int a,b;
	printf("Inserisci 2 numeri separati da uno spazio: ");
	scanf("%d %d", &a,&b);
	printf("Il massimo è: %d", a>b? a:b);
	return 0;
}