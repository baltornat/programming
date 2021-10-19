#include <stdio.h>

#define N 100

void integerSort(int a[],int fine){
	int b[N],i,x,j,h;
	for(i=0;i<fine;i++){
		b[i]=0;
	}
	for(i=0;i<fine;i++){
		x=a[i];
		b[x]=b[x]+1;
	}
	j=0;
	for(i=0;i<fine;i++){
		for(h=0;h<b[i];h++){
			a[j]=i;
			j=j+1;
		}
	}
}

int main(void){
	int fine,i,a[N]={0};
	printf("Inserisci il numero di elementi dell'array (questo valore sarà anche il massimo degli elementi che potrai inserire): ");
	scanf("%d",&fine);
	for(i=0;i<fine;i++){
		printf("Inserisci l'elemento %d: ",i+1);
		scanf("%d",&a[i]);
	}
	integerSort(a,fine);
	return 0;
}