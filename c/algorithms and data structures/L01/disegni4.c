#include <stdio.h>

int main(void){
	int i,j,n,cont,cont1;
	printf("Inserisci n: ");
	scanf("%d",&n);
	cont = n+1;
	cont1 = n+1;
	for(i=0;i<n;i++){
		for(j=0;j<=cont;j++){
			if(j==cont1){
				printf("*");
			}else{
				if(j<cont1){
					printf(".");
				}else{
					if(j>cont1){
						printf(".");
					}
				}
			}
		}
		cont1--;
		printf("\n");
	}
	return 0;
}