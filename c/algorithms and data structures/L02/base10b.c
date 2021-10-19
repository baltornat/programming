#include <stdio.h>
#define N 100

int main(void){
    int arr[N];
    int b,n,ris,i;
    printf("Inserisci un intero b e un numero in base 10 da convertire in base b: ");
    scanf("%d%d",&b,&n);
    ris=n;
    for(i=0;i<N;i++){
        arr[i]=-1;
    }
    i=0;
    while(ris!=0){
        arr[i]=ris%b;
        ris=ris/b;
        i++;
    }
    for(i=N-1;i>=0;i--){
        if(arr[i]>=0)
            printf("%d",arr[i]);
    }
    printf("\n");
    return 0;
}