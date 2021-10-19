#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define N 30

typedef int bool;
#define true 1
#define false 0

struct occorrenza{
	char *word;
	int n;
};
typedef struct occorrenza *Occ;

struct node{
	Occ o;
	struct node *l,*r;
};
typedef struct node *Bist_node;

char *readline(){
	char *array=malloc(N),c;
	int i=0;
	do{
		scanf("%c",&c);
		c=tolower(c);
		array[i]=c;
		i++;
	}while(isalpha(c));
	array[i-1]='\0';
	return array;
}

Occ new_occ(char *stringa){
	Occ o=malloc(sizeof(Occ));
	o->word=stringa;
	o->n=1;
}

Bist_node new_node(Occ o){
	Bist_node b=malloc(sizeof(Bist_node));
	b->o=o;
	b->l=NULL;
	b->r=NULL;
	return b;
}

void insert(Bist_node *root,char *stringa){
	Occ o;
	if(*root==NULL){
		o=new_occ(stringa);
		*root=new_node(o);
	}else{
		if(strcmp((*root)->o->word,stringa)==0){
			(*root)->o->n++;
		}else if(strcmp(stringa,(*root)->o->word)<0){
				insert(&((*root)->l),stringa);
		}else if(strcmp(stringa,(*root)->o->word)>0){
				insert(&((*root)->r),stringa);
		}
	}
}

/*void bist_printassummary(Bist_node p,int spaces){
	if(p){
		for(int i=0;i<spaces;i++)
			printf("\t");
		printf("*%s\n",p->o->word);
		if(p->l==NULL && p->r!=NULL){
			for(int i=0;i<=spaces;i++)
				printf("\t");
			printf("*\n");
		}
		bist_printassummary(p->l,spaces+1);
		if(p->l!=NULL && p->r==NULL){
			for(int i=0;i<=spaces;i++)
				printf("\t");
			printf("*\n");
		}
		bist_printassummary(p->r,spaces+1);
	}
}*/

bool bist_search(Bist_node p,char *stringa,bool trovato){
	if(p){
		if(strcmp(stringa,p->o->word)!=0){
			trovato=bist_search(p->l,stringa,trovato);
			trovato=bist_search(p->r,stringa,trovato);
		}else{
			trovato=true;
			printf("%s --> %d\n",stringa,p->o->n);
		}
	}
	return trovato;
}

void bist_printnode(Bist_node p){
	printf("%s -> %d\n",p->o->word,p->o->n);
}

void bist_orderprint(Bist_node p){
	if(p){
		bist_orderprint(p->l);
		bist_printnode(p);
		bist_orderprint(p->r);
	}
}

void bist_invorderprint(Bist_node p){
	if(p){
		bist_invorderprint(p->r);
		bist_printnode(p);
		bist_invorderprint(p->l);
	}
}

void bist_free(Bist_node p){
	if(p){
		bist_free(p->l);
		bist_free(p->r);
		free(p);
	}
}

int main(void){
	bool trovato=false;
	char *stringa;
	Occ o;
	Bist_node root=NULL;
	printf("Inserisci il primo testo:\n");
	do{
		stringa=readline();
		if(strcmp(stringa,"stop")!=0){
			insert(&root,stringa);
		}
	}while(strcmp(stringa,"stop")!=0);
	//bist_printassummary(root, 1);
	printf("\n### STAMPA IN ORDINE ###\n");
	bist_orderprint(root);
	printf("\n### STAMPA INVERTITA ###\n");
	bist_invorderprint(root);
	printf("\nInserisci il secondo testo:\n");
	do{
		stringa=readline();
		if(strcmp(stringa,"stop")!=0){
			trovato=bist_search(root,stringa,trovato);
			if(trovato==false){
				printf("%s --> 0\n",stringa);
			}
			trovato=false;
		}
	}while(strcmp(stringa,"stop")!=0);
	bist_free(root);
	return 0;
}