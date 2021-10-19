#include <stdio.h>
#include "libpsgraph.h"

void curva(double x, int i){
	if(i==0){
		draw(x);
	}else{
		curva(x/3,i-1);
		turn(-60);
		curva(x/3,i-1);
		turn(120);
		curva(x/3,i-1);
		turn(-60);
		curva(x/3,i-1);
	}
}

int main(void){
	int i;
	double x;
	printf("Inserisci la lunghezza x: ");
	scanf("%lf",&x);
	printf("Inserisci l'ordine: ");
	scanf("%d",&i);
	start("koch.ps");
	curva(x,i);
	end();
	return 0;
}