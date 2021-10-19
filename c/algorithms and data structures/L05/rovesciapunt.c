#include <stdio.h>

#define N 100

int main(void){
	int arr[N] = {0};
	int i=0;
    int *p;
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
    for(p=arr+N-1;p>=arr;p--){
        if(*p!=0){
            printf("%d\n",*p);
        }
    }
	return 0;
}