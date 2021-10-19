#include <stdio.h>

typedef int bool;
#define true 1
#define false 0

int main(void){
	int n,i,j;
	bool cross=false;
	printf("Inserisci un numero intero n: ");
	scanf("%d",&n);
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			if(cross==true){
				printf("+ ");
				cross=false;
			}
			else{
				printf("o ");
				cross=true;
			}
		}
		printf("\n");
		if(cross==false && n%2==0){
			cross=true;
		}else{
			if(cross==true && n%2==0){
				cross=false;
			}
		}
	}
	return 0;
}