#include <stdio.h>

#define N 100

void scambia(int a[],int i,int j){
	int aux;
	aux=a[i];
	a[i]=a[j];
	a[j]=aux;
}

void selectionSort(int a[],int n){
	int max=0,i;
	if(n==1)
		return;
	for(i=0;i<n;i++){
		if(a[i]>=a[max])
			max=i;
	}
	scambia(a,max,n-1);
	selectionSort(a,n-1);
}

int main(void){
	int lung,i,a[N]={0};
	printf("Inserisci il numero di elementi dell'array: ");
	scanf("%d",&lung);
	for(i=0;i<lung;i++){
		printf("Inserisci l'elemento %d: ",i+1);
		scanf("%d",&a[i]);
	}
	selectionSort(a,lung);
	return 0;
}