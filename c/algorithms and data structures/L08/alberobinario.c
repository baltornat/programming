#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 11

typedef struct Bit_node{
	int key;
	struct Bit_node *l, *r;
}Bit_node;

Bit_node *bit_new(int key){
	Bit_node *node=malloc(sizeof(struct Bit_node));
	if(node==NULL){
		printf("Errore durante l'allocazione del nodo!\n");
	}
	node->key=key;
	node->l=NULL;
	node->r=NULL;
	return node;
}

Bit_node *bit_arr2tree(int a[], int i){
	Bit_node *node=bit_new(a[i]);
	if((2*i+2)<N){
		node->l=bit_arr2tree(a,(2*i)+1);
		node->r=bit_arr2tree(a,(2*i)+2);
	}else if((2*i+1)<N){
		node->l=bit_arr2tree(a,(2*i)+1);
		node->r=NULL;
	}else{
		node->l=NULL;
		node->r=NULL;
	}
	return node;
}

void printassummary(Bit_node *b,int spaces){
	if(b==NULL){
		printf("*\n");
	}
	else if(b->l==NULL && b->r==NULL){
		printf("*%d\n", b->key);
	}
	else{
		printf("*%d\n", b->key);

		for(int i=0; i<spaces; i++)
			printf(" ");
		printassummary(b->l,spaces+spaces);
		

		for(int i=0; i<spaces; i++)
			printf(" ");
		printassummary(b->r,spaces+spaces);
	}
}

int main(void){
	Bit_node *root;
	int a[N];
	srand(time(NULL));
	for(int i=0;i<N;i++){ 
		a[i] = rand()%50;
		printf("%d) --> %d\n",i,a[i]);
	}
	root = bit_arr2tree(a,0);
	printassummary(root,1);
	return 0;
}