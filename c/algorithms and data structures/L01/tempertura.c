#include <stdio.h>

int main(void){
	float temp;
	printf("Inserisci la temperatura da convertire: ");
	scanf("%f", &temp);
	printf("La temperatura in gradi celsius è %f \n", temp);
	temp = (1.8 * temp) + 32;
	printf("La temperatura in gradi fahrenheit è %f \n", temp);
	return 0;
}

