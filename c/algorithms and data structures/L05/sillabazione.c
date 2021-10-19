#include <stdio.h>
#include <string.h>

int main(int argc,char *argv[]){
	char parola[100]={0};
	strcpy(parola,argv[1]);
	for(int i=0;i<strlen(parola);i++){
		printf("%c",parola[i]);
		if(parola[i+1]<parola[i] && parola[i+1]!='\0')
			printf("-");
	}
	return 0;
}