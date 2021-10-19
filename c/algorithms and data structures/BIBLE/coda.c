/******/
/*CODA*/
/******/

struct element{
	char ch;
	struct element *next;
};

typedef struct queue{
	struct element *head;
	struct element *tail;
	int count;
}*Queue;

/*INIZIALIZZAZIONE DELLA CODA*/
Queue init(){
  Queue q = malloc(sizeof(struct queue));
  q->head = NULL;
  q->count = 0;
  return q;
}

/*INSERIMENTO NELLA CODA*/
void enqueue(char ch, Queue q){
  struct element *new = malloc(sizeof(struct element));
  new->ch = ch;
  new->next = NULL;
  if (q->head == NULL)
    q->head = new; // la coda era vuota
  else {
    q->tail->next = new; // attacco in coda
  }
  q->tail = new;
  q->count++;
}

/*ESTRAZIONE DALLA CODA*/
char dequeue(Queue q){
  char ch;
  struct element *testa = q->head;
  ch = testa->ch;
  q->head = q->head->next;
  free(testa);
  q->count--;
  return ch;
}