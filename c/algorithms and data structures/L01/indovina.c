#include <stdio.h>
#include <time.h>

int main(void){
	char n;
	int guess=500;
	int min=0, max=1000;
	while(1){
		printf("Il numero è %d?\n", guess);
		scanf(" %c", &n);
		if(n=='='){
			printf("Hai indovinato!");
			break;
		}else{
			if(n=='<'){
				max/=2;
				guess = max/2;
			}else{
				min=guess;
				guess=max/2;
			}
		}
	}
	return 0;
}