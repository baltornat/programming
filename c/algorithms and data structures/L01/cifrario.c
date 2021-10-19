#include <stdio.h>

int main(void){
	int key,i;
	char c;
	printf("Inserisci la chiave: ");
	scanf("%d",&key);
	printf("Inserisci il testo da cifrare: ");
	c = getchar();
	while(c!='.'){
		if((c>='A' && c<='Z')||(c>='a' && c<='z')){
			putchar(c+key);
		}else{
			putchar(c);
		}
		c = getchar();
	}
	return 0;
}