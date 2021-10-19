#include <stdio.h>
#include <math.h>

int main(void){
	float a,b,c;
	float s1,s2;
	printf("Inserisci tre coefficienti: \n");
	scanf("%f %f %f", &a, &b, &c);
	s1 = ((-1*b)+sqrt(b*b-(4*a*c)))/(2*a);
	s2 = ((-1*b)-sqrt(b*b-(4*a*c)))/(2*a);
	printf("Soluzione 1 = %f\n", s1);
	printf("Soluzione 2 = %f\n", s2);
	return 0;
}