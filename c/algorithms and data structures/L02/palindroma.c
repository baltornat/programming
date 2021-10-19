#include <stdio.h>
#include <string.h>

int main(void){
	char parola[100]={0};
	int i,l;
	printf("Inserisci una stringa: ");
	scanf("%s",parola);
	l=strlen(parola);
	for(i=0;i<l/2;i++){
		if(parola[i]!=parola[l-1-i]){
			printf("La parola non è palindroma!\n");
			return 0;
		}
	}
	printf("La parola è palindroma!\n");
	return 0;
}