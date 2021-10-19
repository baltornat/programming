#include <stdio.h>

#define N 100

void insertionSort(int a[],int lung){
	int value,j;
	if(lung>1){
		insertionSort(a,lung-1);
		value = a[lung-1];
		j=lung-2;
		while(j>=0 && a[j]>value){
			a[j+1]=a[j];
			j=j-1;
		}
		a[j+1]=value;
	}
}

int main(void){
	int lung,i,a[N]={0};
	printf("Inserisci il numero di elementi dell'array: ");
	scanf("%d",&lung);
	for(i=0;i<lung;i++){
		printf("Inserisci l'elemento %d: ",i+1);
		scanf("%d",&a[i]);
	}
	insertionSort(a,lung);
	return 0;
}