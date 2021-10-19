#include <stdio.h>
#include <ctype.h>
#include <string.h>

char *maiuscolo(char *stringa){
	toupper(*stringa);
	return &stringa[0];
}

int main(void){
	char stringa[100]={0};
	char *maiusc;
	int lung;
	printf("Inserisci una stringa: ");
	scanf("%s",stringa);
	lung=strlen(stringa);
	maiusc=maiuscolo(stringa);
	for(maiusc;maiusc<maiusc+lung;maiusc++){
		printf("%c",*maiusc);
	}
	return 0;
}