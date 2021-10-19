#include <stdio.h>

#define N 100

void scambia(int a[],int i,int j){
	int aux;
	aux=a[i];
	a[i]=a[j];
	a[j]=aux;
}

int partizione(int a[],int inizio,int fine){
	int perno,sx,dx;
	perno=a[inizio];
	sx=inizio;
	dx=fine;
	while(sx<dx){
		do{
			dx=dx-1;
		}while(a[dx]>perno);
		do{
			sx=sx+1;
		}while(sx<dx && a[sx]<=perno);
		if(sx<dx){
			scambia(a,sx,dx);
		}
	}
	scambia(a,dx,inizio);
	return dx;
}

void quickSort(int a[],int inizio,int fine){
	int m;
	if((fine-inizio)>1){
		m=partizione(a,inizio,fine);
		quickSort(a,inizio,m);
		quickSort(a,m+1,fine);
	}
}

int main(void){
	int fine,i,a[N]={0};
	printf("Inserisci il numero di elementi dell'array: ");
	scanf("%d",&fine);
	for(i=0;i<fine;i++){
		printf("Inserisci l'elemento %d: ",i+1);
		scanf("%d",&a[i]);
	}
	quickSort(a,0,fine);
	return 0;
}