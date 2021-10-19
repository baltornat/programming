#include <stdio.h>

int main(void){
	char c1,c2;
	int x;
	printf("Inserisci 2 caratteri: ");
	scanf("%c %c", &c1, &c2);
	if(c1>c2){
		x = c1-c2;
		printf("Differenza = %d", x+1);
	}else{
		if(c1<c2){
			x = c2-c1;
			printf("Differenza = %d", x+1);
		}else{
			x = 0;
			printf("Differenza = %d", x);
		}
	}
	return 0;
}