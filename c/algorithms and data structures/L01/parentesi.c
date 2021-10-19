#include <stdio.h>

int main(void){
	char c;
	int contpa=0;
	int contpc=0;
	int cont_caratteri=0;
	printf("Inserisci una sequenza di caratteri (termina con '.'): ");
	while(c!='.'){
		c=getchar();
		cont_caratteri++;
		if(c=='('){
			contpa++;
		}
		if(c==')'){
			contpc++;
		}
		if(contpa<contpc){
			printf("L'espressione non è ben parentesizzata!\n");
			printf("Carattere %d: troppe parentesi chiuse!\n",cont_caratteri);
			return 0;
		}
		if(c=='.' && contpa>contpc){
			cont_caratteri--;
			printf("L'espressione non è ben parentesizzata!\n");
			printf("Carattere %d: mancano parentesi chiuse alla fine!\n",cont_caratteri);
		}
	}
	if(contpa==contpc){
		printf("L'espressione è ben parentesizzata!\n");
	}
	return 0;
}