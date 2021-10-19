#include <stdio.h>
#include <ctype.h>

int main(void){
	char c;
	printf("Inserisci un carattere: ");
	scanf("%c", &c);
	if((c >= 65 && c<= 90)||(c >= 97 && c <= 122)){
		char l = tolower(c);
		if(l=='a' || l=='e' || l=='i' || l=='o' || l=='u'){
			printf("%c è una vocale!", c);
		}else{
			printf("%c è una consonante!", c);
		}
	}else{
		printf("%c non è un carattere italiano...", c);
	}
	return 0;
}