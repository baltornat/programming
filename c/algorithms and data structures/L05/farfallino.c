#include <stdio.h>
#include <string.h>

int main(int argc,char *argv[]){
	char parola[100]={0};
	strcpy(parola,argv[1]);
	for(int i=0;i<strlen(parola);i++){
		printf("%c",parola[i]);
		switch(parola[i]){
			case 'a': printf("fa");
			break;
			case 'e': printf("fe");
			break;
			case 'i': printf("fi");
			break;
			case 'o': printf("fo");
			break;
			case 'u': printf("fu");
			break;
		}
	}
	return 0;
}