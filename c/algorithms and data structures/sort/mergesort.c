#include <stdio.h>

#define N 100

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

void mergeSort(int a[],int sx,int dx){
	int centro;
	if(sx<dx){
		centro=(sx+dx)/2;
		mergeSort(a,sx,centro);
		mergeSort(a,centro+1,dx);
		merge(a,sx,centro,dx);
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
	mergeSort(a,0,lung-1);
	return 0;
}