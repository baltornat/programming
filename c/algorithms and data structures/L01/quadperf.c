#include <stdio.h>
#include <math.h>

#define N 100

int main(void){
	int i;
	for(i=0; i<N; i++){
		if(sqrt(pow(i,2))==i){
			int quad = pow(i,2);
			printf("Quadrato: %d\n", quad);
		}
	}
	return 0;
}