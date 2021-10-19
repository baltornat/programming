/***************/
/*ALBERI BINARI*/
/***************/

struct bit_node{
    Item key;              	/*Item può essere un intero ect. etc.*/
    struct bit_node *l, *r; /*puntatori a figlio sinistro e destro*/
};

typedef struct bit_node *Bit_node;

/*CREA UN NUOVO NODO*/
Bit_node bit_new(int key){
	Bit_node node=malloc(sizeof(struct bit_node));
	if(node==NULL){
		printf("Errore durante l'allocazione del nodo!\n");
	}
	node->key=key;
	node->l=NULL;
	node->r=NULL;
	return node;
}

/*TRASFORMA UN ARRAY IN UN ALBERO*/
Bit_node bit_arr2tree(int a[], int i){		//prima chiamata i=0
	Bit_node node=bit_new(a[i]);
	if((2*i+2)<N){							//N=il numero di elementi dell'array
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

/*STAMPA L'ALBERO*/
void printassummary(Bit_node b,int spaces){
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