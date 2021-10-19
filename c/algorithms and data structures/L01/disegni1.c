#include <stdio.h>

typedef int bool;
#define true 1
#define false 0

int main(void){
	int n,i,j;
	bool cross=true;
	printf("Inserisci un numero intero n: ");
	scanf("%d",&n);
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			if(cross==true)
				printf("+ ");
			else
				printf("o ");
		}
		printf("\n");
		if(cross==true)
			cross=false;
		else
			cross=true;
	}
	return 0;
}