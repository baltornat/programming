#include <stdio.h>
#include <stdlib.h>

int main(void){
    int *array;
    int i = 0, n;
    size_t dim = sizeof(int)*5;
    array = malloc(dim);  
    do{
        printf("Inserisci l'elemento %d: ",i);
        scanf("%d", &n);
        if(n == 0){
            break;
        }
        array[i] = n;
        i++;
        if(sizeof(int)*i == dim){
            dim *= 2;
            array = realloc(array, dim);
        }
    }while(n != 0);
    for(int j=i;j>=0;j--){
        printf("Elemento %d: %d\n",j,array[j]);
    }
    free(array);
    return 0;
}