#include <stdio.h>

int main(void){
	int mese,giorno;
	int i,j;
	int cont=0;
	int l_mese;
	printf("Inserisci il numero del mese (1=gennaio,...,12=dicembre): ");
	scanf("%d",&mese);
	printf("Inserisci il giorno di inizio mese (1=lunedì,...,7=domenica): ");
	scanf("%d",&giorno);
	printf("L   M   M   G   V   S   D\n");
	switch(mese){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: l_mese=31;
		break;
		case 4:
		case 6:
		case 9:
		case 11: l_mese=30;
		break;
		case 2: l_mese=28;
		break;
		default: return 0;
	}
	for(i=1;i<giorno;i++){
		printf("    ");
	}
	for(i=giorno;i<=7;i++){
		cont++;
		printf("%d   ",cont);
	}
	printf("\n");
	while(1){
		for(j=0;j<7;j++){
			if(cont==l_mese){
				printf("\n");
				return 0;
			}
			cont++;
			if(cont>9)
				printf("%d  ",cont);
			else
				printf("%d   ",cont);
		}
		printf("\n");
	}
	return 0;
}