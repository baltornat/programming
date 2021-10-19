#include <stdio.h>

#define N 100

typedef int bool;
#define true 1
#define false 0

void scambia(int a[],int i,int j){
	int aux;
	aux=a[i];
	a[i]=a[j];
	a[j]=aux;
}

void bubbleSort(int a[],int lung){
	int i=0,j;
	bool scambiato;
	do{
		scambiato=false;
		for(j=1;j<lung-i;j++){
			if(a[j]<a[j-1]){
				scambia(a,j,j-1);
				scambiato=true;
			}
		}
		i=i+1;
	}while(scambiato==true && i<lung);
}

int main(void){
	int lung,i,a[N]={0};
	printf("Inserisci il numero di elementi dell'array: ");
	scanf("%d",&lung);
	for(i=0;i<lung;i++){
		printf("Inserisci l'elemento %d: ",i+1);
		scanf("%d",&a[i]);
	}
	bubbleSort(a,lung);
	return 0;
}