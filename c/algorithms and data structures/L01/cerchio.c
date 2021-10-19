#include <stdio.h>
#include <math.h>

int main(void){
	float r;
	printf("Inserisci il raggio di un cerchio: ");
	scanf("%f", &r);
	float area = pow(r,2)*M_PI;
	printf("L'area è %f:", area);
	return 0;
}