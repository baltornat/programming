#include <stdio.h>
#include <string.h>

int main(int argc,char *argv[]){
	char parola[100]={0};
	int l,i=0;
	char *p;
	strcpy(parola,argv[1]);
	l=strlen(parola);
	for(p=parola;p<(parola+(l/2));p++){
		if(*p!=*(p+(l-1-i))){
			printf("La parola non è palindroma!\n");
			return 0;
		}
		i+=2;
	}
	printf("La parola è palindroma!\n");
	return 0;
}