/******/
/*PILA*/
/******/

typedef char *Item;
// Pila implementata come lista di interi (inserimento e cancellazione avvengono solo in testa)
struct element {
  Item value;
  struct element *next;
};
typedef struct element Element;

struct stack {
  Element *head;
};
typedef struct stack *Stack;

/*INIZIALIZZAZIONE DELLO STACK*/
Stack init( void ) {
  Stack s = malloc( sizeof (struct stack) );
  if ( s == NULL ) {
    printf( "err malloc\n" );
    exit( EXIT_FAILURE );
  }
  s -> head = NULL;
  return s;
}

/*STAMPO LO STACK*/
void print_stack( Stack s ) {
  Element *p;
  if ( s == NULL )
    return;
  printf( "Contenuto della pila: " );
  for ( p = s -> head; p != NULL; p = p -> next ) {
    printf( "%s", p -> value );
    printf( " " );
  }
  printf( ".\n" );
}

/*DISTRUGGE LA PILA*/
void destroy( Stack s ) {
  Element *p, *old;
  for ( p = s -> head; p != NULL; ) {
    old = p;
    p = p -> next;
    free( old );
  }
  free( s );
}

/*INSERISCE UN ELEMENTO IN TESTA*/
void push( Stack s, Item item ){
  Element *new = malloc( sizeof( Element ) );
  if ( new == NULL ) {
    printf( "err push: pila piena!\n" );
    exit( EXIT_FAILURE );
  }
  new -> value = item;
  new -> next = s -> head;
  s -> head = new;
}

/*ELIMINAZIONE DI UN ELEMENTO IN TESTA*/
Item pop( Stack s ){
  Item item;
  Element *old;
  if ( is_empty( s ) ) {
    printf( "err pop: pila vuota\n" );
    exit( EXIT_FAILURE );
  }
  strcpy(item, top(s));
  old=s->head;
  s->head=s->head->next;
  free(old);
  return item;
}