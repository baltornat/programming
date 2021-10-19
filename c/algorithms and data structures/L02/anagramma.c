#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(void){
	char s1[100],s2[100];
	int i,j,cont1=0,cont2=0;
	printf("Inserisci la prima parola: ");
	scanf("%s",s1);
	printf("Inserisci la seconda parola: ");
	scanf("%s",s2);
	if(strlen(s1)!=strlen(s2)){
		printf("Le parole non sono anagrammi!");
		return 0;
	}
	else{
		for(i=97;i<123;i++){
			for(j=0;j<strlen(s1);j++){
				if(s1[j]==i){
					cont1++;
				}
			}
			if(cont1>0){
				for(j=0;j<strlen(s2);j++){
					if(s2[j]==i){
						cont2++;
					}
				}
				if(cont1!=cont2){
					printf("Le parole non sono anagrammi!");
					return 0;
				}
				cont1=0;
				cont2=0;
			}
		}
		printf("Le parole sono anagrammi!");
	}
	return 0;
}