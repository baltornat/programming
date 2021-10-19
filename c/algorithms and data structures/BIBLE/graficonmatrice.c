/*******************/
/*GRAFI CON MATRICE*/
/*******************/

struct graph{
	int n,m;
	int **A;
};

struct coda{
	int v;
	struct coda *next;
};

typedef struct graph *Graph;

/*CREAZIONE DEL GRAFO*/
Graph graph_new(int n){
	Graph g=calloc(1,sizeof(struct graph));
	if(!g)
		exit(0);
	g->A=calloc(n,sizeof(int *));
	if(!g->A)
		exit(0);
	for(int i=0; i<n; i++){
		g->A[i]=calloc(1,sizeof(int));
	}

	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++)
			g->A[i][j]=0;
	}
	g->n=n;
	return g;
}

/*DISTRUZIONE DEL GRAFO*/
void destroy(Graph g){
	for(int i=0; i<g->n;i++)
		free(g->A[i]);
	free(g);
}

/*INSERIMENTO DI UN NUOVO NODO*/
void graph_edgeinsert(Graph g, int v, int w){
	g->A[v][w]=1;
	g->A[w][v]=1;
}

/*VISITA BFS CON CODA*/
void bfs1(struct graph *g, int i, int *aux){
	struct node *t;
	Queue *q=createqueue();
	enqueue(q,i);
	while(!empty(q)){
		i=dequeue(q);
		aux[i]=1;
		for(t=g->A[i];t;t=t->next){
			if(!aux[t->v-1]){
				enqueue(q,t->v-1);
				printf("%d, ",t->v);
				aux[t->v-1]=1;
			}
		}
	}
	destroyqueue(q);
}

void bfs(struct graph *g){
	int i, *aux=calloc(g->V,sizeof(int));
	if(!aux){
		printf("Errore di allocazione\n");
		exit(-4);
	}
	for(i=0;i<g->V;i++){
		if(!aux[i]){
			printf("\n%d,",i+1);
			bfs1(g,i,aux);
		}
	}
	free(aux);
}