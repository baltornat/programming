/******************/
/*CODE DI PRIORITÀ*/
/******************/

/*NOTA BENE
le code di priorità sono realizzate mediante heap, ossia una struttura
costruita mediante la seguente proprietà: il padre è sempre maggiore dei suoi
figli sinistro e destro*/

typedef Item *Heap;     /*Item può essere int etc. etc.*/

 struct pqueue{         
    Heap h;
    int size, count;    /*size=numero di elementi*/
 }                      /*count=contatore numero di elementi per inserimento*/
typedef struct pqueue *Pqueue;

/*CREAZIONE DELLA CODA DI PRIORITÀ*/
Pqueue pqueue_new ( int n ){
	Pqueue new=calloc(1,sizeof(struct pqueue));
	int *array=calloc(n+1, sizeof(int));
	array[0]=-1;
	new->h=array;
	new->size=n+1;
	new->count=1;
	return new;
}

/*INSERIMENTO IN CODA DI PRIORITÀ*/
void pqueue_insert (Pqueue p, int n){
	if(p->count<p->size){
		p->h[p->count]=n;
		heapify_up(p->h, p->count);
		p->count++;
	}
}

/*NOTA BENE
uno heap può essere rappresentato con un array*/

/*COSTRUZIONE DI UNO HEAP*/
void heapify_up(Heap h, int i){
    if(i>1){                    /*parte da 1 perchè la posizione 0 è vuota*/
        int j=i/2;              /*il padre è l'elemento i/2*/
        if(h[i]<h[j]){
            swap(h,i,j);
            heapify_up(h,j);
        }
    }
}

/*HEAPIFY DOWN*/
void heapify_down ( Heap h, int i, int n) {
	if(2*i <= n){ 
		int j; 
		if(2*i==n)
			j=2*i;
		else
			j= h[2*i] < h[2*i+1] ? 2*i : 2*i+1;
		if (h[j]<h[i]){
			swap(h,i,j);
			heapify_down(h,j,n);
		}
	}
}