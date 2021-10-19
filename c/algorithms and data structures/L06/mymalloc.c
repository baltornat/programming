#include <stdio.h>
#include <stdlib.h>

long int *my_malloc(size_t size){
	long int *p;
	p = malloc(size);
	if(p == NULL){
		printf("Allocazione fallita!\n");
        exit(0);
	}else{
		return p;
	}
}

long int *my_realloc(long int *p){
    free(p);
    size_t size;
    printf("Inserisci la nuova dimensione dello spazio da allocare: ");
    scanf("%lu", &size);
    p = my_malloc(size);
}

int main(void){
	long int *p;
    size_t size;
    printf("Inserisci la dimensione dello spazio da allocare: ");
    scanf("%lu", &size);
	p = my_malloc(size);
	printf("Spazio allocato all'indirizzo: %ld\n",p);
    p = my_realloc(p);
    printf("Spazio allocato all'indirizzo: %ld\n",p);
	free(p);
	return 0;
}