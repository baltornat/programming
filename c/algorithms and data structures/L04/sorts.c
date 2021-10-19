#include <stdio.h>

#define N 100

void stampa(int a[],int lung){
	int i;
	for(i=0;i<lung;i++){
		printf("Elemento %d -> %d\n",i+1,a[i]);
	}
}

void scambia(int a[],int i,int j){
	int aux;
	aux=a[i];
	a[i]=a[j];
	a[j]=aux;
}

void selectionsort(int a[],int n){
	int max=0,i;
	if(n==1)
		return;
	for(i=0;i<n;i++){
		if(a[i]>=a[max])
			max=i;
	}
	scambia(a,max,n-1);
	selectionsort(a,n-1);
}

void merge(int a[],int sx,int centro,int dx){
	int i=sx;
	int j=centro+1;
	int k=0;
	int b[dx-sx];
	while(i<=centro && j<=dx){
		if(a[i]<a[j]){
			b[k]=a[i];
			i++;
		}else{
			b[k]=a[j];
			j++;
		}
		k++;
	}
	while(i<=centro){
		b[k]=a[i];
		i++;
		k++;
	}
	while(j<=dx){
		b[k]=a[j];
		j++;
		k++;
	}
	for(k=sx;k<=dx;k++){
		a[k]=b[k-sx];
	}
}

void mergesort(int a[],int sx,int dx){
	int centro;
	if(sx<dx){
		centro=(sx+dx)/2;
		mergesort(a,sx,centro);
		mergesort(a,centro+1,dx);
		merge(a,sx,centro,dx);
	}
}

int main(void){
	int lung,i,a[N]={0},sel;
	printf("Inserisci il numero di elementi dell'array: ");
	scanf("%d",&lung);
	for(i=0;i<lung;i++){
		printf("Inserisci l'elemento %d: ",i+1);
		scanf("%d",&a[i]);
	}
	stampa(a,lung);
	printf("Inserisci 1 per selectionsort, 2 per mergesort: ");
	scanf("%d",&sel);
	if(sel==1){
		selectionsort(a,lung);
	}else{
		mergesort(a,0,lung-1);
	}
	stampa(a,lung);
	return 0;
}