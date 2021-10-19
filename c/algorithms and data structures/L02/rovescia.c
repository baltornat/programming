#include <stdio.h>

#define N 100

int main(void){
	int arr[N] = {0};
	int i=0;
    int n;
	do{
        printf("Inserisci il numero %d: ", i);
        scanf("%d",&n);
        if(n==0){
            break;
        }
        arr[i]=n;
		i++;
    }while(i<N);
    for(i=N-1;i>=0;i--){
        if(arr[i]!=0){
            printf("%d\n",arr[i]);
        }
    }
	return 0;
}