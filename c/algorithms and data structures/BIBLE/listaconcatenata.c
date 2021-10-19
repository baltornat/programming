/*******************/
/*LISTE CONCATENATE*/
/*******************/

struct node{
    int value;          /*dato memorizzato nel nodo*/
    struct node *next;  /*puntatore al prossimo nodo*/
};

typedef struct node *Node;

/*INSERIMENTO IN TESTA*/
Node *add_to_list(Node list, int n){
	Node new_node;
	new_node=my_malloc(sizeof(Node));
	new_node->value=n;
	new_node->next=list;
	return new_node;
}

/*RICERCA DI UN NODO*/
Node *search_list(Node list, int n){
	Node p;
	for(p=list;p!=NULL;p=p->next){
		if(p->value==n)
			return p;
	}
	return NULL;
}

/*CANCELLAZIONE DI UN NODO*/
Node *delete(Node list, int n){		//n=valore da eliminare
	Node cur,prev;
	for(cur=list,prev=NULL; 		//questo for serve solo per scorrere fino
		cur!=NULL && cur->value!=n; //all'elemento da eliminare
		prev=cur, cur=cur->next){}
	if(cur==NULL)
		return list;
	if(prev==NULL)
		list=list->next;
	else
		prev->next=cur->next;
	free(cur);
	return list;
}

/*STAMPA*/
void print_list(Node h){
	Node p;
	for(p=h;p!=NULL;p=p->next){
		printf("%d\n",p->info);
	}
}

/*DESTROY RICORSIVA*/
void destroy(Node h){
    if(h->next!=NULL){
        destroy(h->next);
    }
    free(h);
}