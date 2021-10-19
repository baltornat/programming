#include <stdio.h>
#include <limits.h>

int *smallest(int a[],int n){
	int min=INT_MAX;
	int aux;
	for(int i=0;i<n;i++){
		if(a[i]<min){
			min=a[i];
			aux=i;
		}
	}
	return &a[aux];
}

void stampa(int a[],int n){
	for(int i=0;i<n;i++){
		printf("Elemento %d -> %d\n",i+1,a[i]);
	}
}

int main(void){
	int a[100]={0};
	int n;
	int *min;
	printf("Quanti elementi vuoi inserire? ");
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		printf("Inserisci elemento %d: ",i+1);
		scanf("%d",&a[i]);
	}
	stampa(a,n);
	min=smallest(a,n);
	printf("%d",*min);
	return 0;
}