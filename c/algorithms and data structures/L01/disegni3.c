#include <stdio.h>

int main(void){
	int i,j,n;
	int cont=0;
	printf("Inserisci n: ");
	scanf("%d",&n);
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			if(j==i){
				printf("| ");
			}else{
				if(j<i){
					printf("o ");
				}else{
					printf("+ ");
				}
			}
		}
		printf("\n");
	}
	return 0;
}