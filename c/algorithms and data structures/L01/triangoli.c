#include <stdio.h>

int main(void){
	int l1,l2,l3;
	printf("Inserisci i lati separati da uno spazio: ");
	scanf("%d %d %d", &l1, &l2, &l3);
	if(((l1+l2)>l3) && ((l1+l3)>l2) && ((l2+l3)>l1)){
		if(l1==l2 && l2==l3){
			printf("Il triangolo è equilatero");
		}else{
			if(l1==l2 || l2==l3 || l1==l3){
				printf("Il triangolo è isoscele");
			}else{
				printf("Il triangolo è scaleno");
			}
		}
	}else{
		printf("Non sono i lati di un triangolo!");
	}
	return 0;
}