#include <stdio.h>
#include <stdlib.h>

typedef int *Heap;

struct pqueue{
	Heap h;
	int size, count;
};
typedef struct pqueue *Pqueue;

Pqueue pqueue_new(int);
void pqueue_insert(Pqueue, int);
int pqueue_min(Pqueue);
void heapify_up(Heap, int);
void heapify_down(Heap, int, int);
void swap(Heap, int, int);
void pqueue_print(Pqueue);
void pqueue_destroy(Pqueue);
int pqueue_length(Pqueue);
void pqueue_extractmin(Pqueue);

int main(void){
	Pqueue coda;
	int lung,e,min;
	printf("Quanti elementi vuoi inserire? ");
	scanf("%d",&lung);
	coda=pqueue_new(lung);
	for(int i=0;i<lung;i++){
		printf("Inserisci l'elemento %d: ",i);
		scanf("%d",&e);
		pqueue_insert(coda,e);
	}
	pqueue_print(coda);
	lung=pqueue_length(coda);
	printf("La coda è lunga: %d\n",lung);
	min=pqueue_min(coda);
	printf("Il minimo è: %d\n",min);
	printf("\n###STAMPA ORDINATA###\n\n");
	for(int i=0;i<lung;i++){
		pqueue_extractmin(coda);
	}
	pqueue_destroy(coda);
	return 0;
}

Pqueue pqueue_new(int n){
	Pqueue p=malloc(sizeof(Pqueue));
	if(p==NULL){
		printf("Errore durante l'allocazione della coda!\n");
		exit(0);
	}
	p->h=malloc(sizeof(int)*n);
	if(p->h==NULL){
		printf("Errore durante l'allocazione dell'array!\n");
		exit(0);
	}
	p->size=n;
	p->count=0;
	return p;
}

void swap(Heap h, int i, int j){
	int aux;
	aux=h[i];
	h[i]=h[j];
	h[j]=aux;
}

void heapify_up(Heap h, int i){
	if(i>0){
		int j=i/2;
		if(h[i]<h[j]){
			swap(h,i,j);
			heapify_up(h,j);
		}
	}
}

void pqueue_insert(Pqueue p, int e){
	p->h[p->count]=e;
	heapify_up(p->h,p->count);
	p->count=p->count+1;
}

void pqueue_print(Pqueue p){
	for(int i=0;i<(p->size);i++){
		printf("%d\n",p->h[i]);
	}
}

int pqueue_min(Pqueue p){
	return p->h[0];
}

void pqueue_destroy(Pqueue p){
	free(p);
	p=NULL;
}

int pqueue_length(Pqueue p){
	return p->size;
}

void heapify_down(Heap h, int i, int n){
	if(2*i<=n){
		int j;
		if(2*i==n){
			j=2*i;
		}
		else{
			if(h[2*i]<h[2*i+1]){
				j=2*i;
			}else{
				j=2*i+1;
			}
		}
		if(h[j]<h[i]){
			swap(h,i,j);
			heapify_down(h,j,n);
		}
	}
}

void pqueue_extractmin(Pqueue p){
	int min;
	min=p->h[0];
	printf("%d\n",min);
	p->h[0]=p->h[p->size-1];
	p->size=p->size-1;
	heapify_down(p->h,0,p->size);
}



