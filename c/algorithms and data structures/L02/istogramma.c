#include <stdio.h>
#include <ctype.h>
#include <string.h>
#define N 100

int main(void){
	char c;
	char stringa[N];
	int array[N];
	int i=0,j,cont=0;
	printf("Inserisci una sequenza di caratteri: ");
	do{
		c=toupper(getchar());
		if(c=='.')
			break;
		stringa[i]=c;
		i++;
	}while(i<N);
	for(i=65;i<91;i++){
		for(j=0;j<strlen(stringa);j++){
			if(stringa[j]==i){
				cont++;
			}
		}
		if(cont>0){
			printf("%c -> ",i);
			for(j=0;j<cont;j++){
				printf("*");
			}
			printf("\n");
			cont=0;
		}
	}
	return 0;
}