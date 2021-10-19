#include <stdio.h>
#include <stdlib.h>

struct element{
	int info;
	struct element *next;
};
typedef struct element element;

int isMember(int n,element *h){
	element *p;
	for(p=h;p!=NULL;p=p->next){
		if(p->info == n){
			return 1;
		}
	}
	return 0;
}

element *insert(int n,element *h){
	element *new_node=NULL;
	if(h==NULL){
		h=malloc(sizeof(element));
		if(h==NULL){
			printf("Errore durante l'allocazione della lista concatenata!\n");
			exit(0);
		}
		h->info=n;
		h->next=NULL;
		return h;		
	}else{
		if(isMember(n,h)==1){
			printf("Elemento già inserito!\n");
			return h;
		}else{
			new_node=malloc(sizeof(element));
			new_node->info=n;
			new_node->next=h;
			return new_node;
		}
	}
}

void printList(element *h){
	element *p;
	for(p=h;p!=NULL;p=p->next){
		printf("%d\n",p->info);
	}
}

element *delete(int n,element* h){
	element *p,*prec=h;
	if(isMember(n,h)==0){
		printf("Elemento non presente nella lista!\n");
		return h;
	}else{
		for(p=h;p!=NULL;p=p->next){
			if(p->info == n && p->next == NULL){
				if(prec == p){
					free(p);
					return NULL;
				}
				free(p);
				prec->next=NULL;
				return h;
			}else{
				if(p->info == n && p->next != NULL){
					if(prec == p){
						free(p);
						return h->next;
					}
					p=p->next;
					free(prec->next);
					prec->next=p;
					return h;
				}
			}
			prec=p;
		}
	}
}

int count(element *h){
	element *p;
	int cont=0;
	for(p=h;p!=NULL;p=p->next){
		cont++;
	}
	return cont;
}

void destroy(element *h){
	if(h->next!=NULL){
		destroy(h->next);
	}
	free(h);
}

void printInv(element *h){
	if(h->next!=NULL){
		printInv(h->next);
	}
	printf("%d\n",h->info);
}

int main(void){
	element *head=NULL;
	char c;
	int n;
	while((c=getchar())!='f'){
		switch(c){
			case '+':
				getchar();
				scanf("%d",&n);
				head=insert(n,head);
			break;
			case '-':
				getchar();
				scanf("%d",&n);
				head=delete(n,head);
			break;
			case '?':
				getchar();
				scanf("%d",&n);
				if(isMember(n,head)==1){
					printf("%d appartiene alla lista!\n",n);
				}else{
					printf("%d non appartiene alla lista!\n",n);
				}
			break;
			case 'c':
				n=count(head);
				printf("La lista contiene %d elementi!\n",n);
			break;
			case 'p':
				printList(head);
			break;
			case 'o':
				if(head){
					printInv(head);
				}
			break;
			case 'd':
				if(head){
					destroy(head);
					head=NULL;
				}
			break;
			case 'f':
				exit(0);
			break;
		}
	}
	return 0;
}