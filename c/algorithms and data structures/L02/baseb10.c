#include <stdio.h>
#include <math.h>
#include <string.h>

int main(void){
	int b,i=0,n=0,l,aux;
	char c;
	char s[100];
	printf("Inserisci un intero b e un numero in base b da convertire in base 10: ");
	scanf("%d",&b);
	printf("Inserisci il numero da convertire: ");
	getchar();
	do{
		c=getchar();
		if(c=='.')
			break;
		s[i]=c;
		i++;
	}while(i<100);
	l=strlen(s);
	aux=l-1;
	for(i=0;i<l;i++){
		n=n+((s[i]-48)*pow(b,aux));
		aux--;
	}
	printf("%d\n",n);
	return 0;	
}