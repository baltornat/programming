#include <stdio.h>
#include <stdlib.h>

#define N 100

struct coda{
	int chiave;
	coda *succ;
};
typedef coda Coda;

Coda new_coda(int chiave){
	Coda *c=malloc(sizeof(Coda));
	c->chiave=chiave;
	c->succ=NULL;
	return c;
}

int enqueue(int chiave){
	Coda *c=new_coda(chiave);
	
}

void bucketSort(int a[],int fine){
	Coda *b[N];
	int i,x;
	for(i=0;i<fine;i++){
		x=a[i];
		b[x]=enqueue(a[i]);
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
	bucketSort(a,fine);
	return 0;
}