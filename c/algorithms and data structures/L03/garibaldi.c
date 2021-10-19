#include <stdio.h>

char cambio(char vocale,char c){
	if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
		return vocale;
	else
		return c;
}

int main(void){
	char c,vocale;
	int i=0;
	printf("Stringa: ");
	vocale=getchar();
	getchar();
	do{
		c=getchar();
		if(c=='.')
			break;
		printf("%c",cambio(vocale,c));
		i++;
	}while(i<100);
	return 0;
}