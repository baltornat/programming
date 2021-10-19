#include <stdio.h>
#define N 100

int main(void){
    char arr[N];
    int i=0;
    char ultimo,c;
    printf("Inserisci una sequenza di caratteri (termina con a capo): ");
    do{
        c=getchar();
        if(c==10){
            ultimo=arr[i-1];
            arr[i]=c;
            break;
        }
        arr[i]=c;
        i++;
    }while(i<N);
    i=0;
    printf("\n");
    do{
        if(arr[i]==10)
            break;
        if(arr[i]==ultimo){
            arr[i]=0;
        }
        printf("%c",arr[i]);
        i++;
    }while(i<N);
    return 0;
}