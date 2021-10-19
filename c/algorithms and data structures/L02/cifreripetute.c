#include <stdio.h>
#include <string.h>

int main(void){
	int n,l,i,j;
	char s[100];
	char aux;
	printf("Inserisci un numero intero: ");
	scanf("%d",&n);
	sprintf(s,"%d",n);
	l=strlen(s);
	for(i=0;i<l;i++){
		aux=s[i];
		for(j=1;j<l;j++){
			if(aux==s[j])
				printf("La cifra %d è ripetuta!",aux);
		}
	}
	return 0;
}