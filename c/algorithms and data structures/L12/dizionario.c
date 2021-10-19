/*** 

Programma che legge un testo e annota in un dizionario le parole con indicazione dei numeri di riga in cui compaiono
Dizionario implementato con hash table + catene di collisione

FORMATO DELL'INPUT:
sequenza di comandi, uno per riga:

  + l ==> legge una riga terminata da @ e inserisce le parole nel dizionario
  ? s ==> stampa i numeri di tutte le righe che contengono la stringa s
  l ==> stampa il numero di righe lette
  n ==> stampa il numero di parole lette
  p ==> stampa tutte le parole del testo (non importa l'ordine
  f  ==>  termina il programma

***/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <strings.h>
#define N 4 // dimensione iniziale dei vettori allocati dinamicamente
#define HASHSIZE 10 // dimensione della tabella di hash

// PAROLA + ELENCO DEI NUMERI DI RIGA IN CUI COMPARE
typedef struct {  // definizione di un elemento della lista 
  char *word;
  int *ln_arr; // array (ordinato) di interi (numeri delle righe in cui compare la parola word)
  int size; // dimensione dell'array
  int count; // posizioni occupate -prima posizione utile- dell'array (numero di righe distinte in cui compare la parola word
} Item;

void item_print ( Item *p );
void item_modify( Item *p, int ln ); 	// modifica l'item puntato da p, aggiungendo ln in ln_arr se non gia' presente nell'ultima posizione 
					//(eventualmente riallocando ln_arr)
Item *item_new( char *w, int ln );

// ELEMENTO DI LISTA
struct element {  // definizione di un elemento della lista 
  Item *item;
  struct element *next;    // prossimo elemento 
};


// CATENA DI COLLISIONE implementata come LISTA CONCATENATA
typedef struct element *Chain;   
Item *chain_find( Chain c, char *w );	// Cerca un item con chiave w nella chain c. Se lo trova ne restituisce l'indirizzo, altrimenti restituisce NULL. 
Chain chain_insert( Chain c, Item *p ); // crea nuovo elemento, lo inserisce in testa alla catena e restituisce l'indirizzo della nuova testa
void chain_print( Chain h );


// DIZIONARIO IMPLEMENTATO CON HASHTABLE
typedef struct ht {
  Chain array[HASHSIZE];
  int count; // parole inserite
} *Dict;

Dict dict_init (); 
void dict_print( Dict h );
Item *dict_lookup ( Dict t, char *w ); // Restituisce l'Item contenente la chiave w, oppure NULL se w non è nel dizionario
void dict_add( Dict t, Item *p ); // aggiunge l'item p nel dizionario (assume che la chiave p -> w non ci sia gia')
unsigned long hash ( char *s ); // funzione di hash


// FUNZIONI GENERICHE
void printArray( int a[], int size);
char *read_word(); // c e' il carattere che terminava la stringa
void line( Dict t, int ln ); // legge una riga terminata da @ e inserisce  nel dizionario le parole della riga



/* MAIN
**************/

int main() {

  Dict dict = dict_init();
  int ln = 0;
  char *w;
  char com;
  
  while(( com = getchar()) != 'f'){
    switch(com){
    case '+': // legge una riga terminate da a-capo e inserisce le parole nel dizionario
	ln++;
	line( dict, ln );
	break;

    case '?':  // ? s:  stampa i numeri di riga in cui compare la stringa s 
	getchar();
	w = read_word();
	printf( "[?] " );

	Item *p = dict_lookup( dict, w );
	if ( p ) 
	   item_print( p );
	else
	   printf( "parola non trovata: %s\n", w );
	break;

    case 'n':  //  stampa il numero di parole lette
	printf( "[n] Lette %d parole distinte\n", dict -> count );
	getchar();
	break;

    case 'l':  //  stampa il numero di righe lette
	printf( "[l] Lette %d righe\n", ln );
	getchar();
	break;

    case 'p':  //  stampa il dizionario
	dict_print( dict );
	getchar();
	break;
    }
  }  
  return 0;

}


/* FUNZIONI PER GESTIRE ITEM 
*******************************************/

Item *item_new( char *w, int ln ) {
  Item *p = malloc( sizeof( Item ) );
  p -> word = w;
  p -> ln_arr = malloc( N * sizeof(int) );
  p -> ln_arr[0] = ln;
  p -> size = N;
  p -> count = 1;

  return p;
}

// Stampa l'Item puntato da p con la parola + l'elenco dei numeri di riga in cui compare
void item_print ( Item *p ) {
  if ( p == NULL )  
	  return;
  printf( "%s: ", p -> word );
  printArray( p -> ln_arr, p -> count );
}

//  Modifica l'Item puntato da p, aggiungendo ln all'array (riallocando l'array se necessario)
void item_modify( Item *p, int ln ){
	
  // se l'ultimo numero di riga inserito e' ln, allora non devo fare nulla
  if ( p -> ln_arr[ p -> count - 1 ] == ln ) 
    return;
 
  // prima di aggiungere ln controllo se e' necessario re-allocare
  if ( p -> size <= p -> count ) {
     p -> size *= 2;
     p -> ln_arr = realloc ( p -> ln_arr, p -> size * sizeof(int) );
  }
  p -> ln_arr[ p -> count++ ] = ln;
}



/* FUNZIONI DI GESTIONE DELLA CHAIN (lista)
*******************************************/

void chain_print( Chain h ){
//  printf( "inizio printList di punt %p{\n", h );
  if ( h == NULL )
    return;	
  printf( "\n" );
  for( ; h != NULL; h = h -> next) 
    item_print( h -> item );

}

// Inserisce in testa e restituisce la nuova testa. 
Chain chain_insert( Chain h, Item *p ){
  struct element *new = malloc( sizeof( struct element ) );
  new -> item = p;
  new -> next = h;
  return new;
}


// Cerca un item con chiave w nella chain c.
// Se lo trova ne restituisce l'indirizzo, altrimenti restituisce NULL.
Item *chain_find( Chain c, char *w ){
  struct element *p;  // p scorre la  lista
  for( p = c  ; p!= NULL; p = p->next ) {
    if( strcmp( p -> item -> word, w ) == 0 ) {
      return p -> item;
    }
  }
  return NULL;
}



/* FUNZIONI DI GESTIONE DELLA HASHTABLE
*******************************************/


// Crea una hastable di con HASHSIZE posizioni
Dict dict_init () {
  Dict t = malloc ( sizeof ( struct ht ) );
  t -> count = 0;

  for ( int i = 0; i < HASHSIZE; i++ )
          t -> array[i] = NULL;
  return t;
} 

// funzione di hash
unsigned long hash( char *str )
{
  unsigned long hash = 5381;
  int c;

  while ( (c = *str++) )
      hash = ((hash << 5) + hash) + c; // hash * 33 + c

  return hash % HASHSIZE;
}


// Cerca w nella tabella di hash e restituisce l'indirizzo dell'item corrispondente a w.
// Restituisce NULL se w non è nel dizionario
Item *dict_lookup ( Dict t, char *w ) {
  return chain_find( t -> array[hash(w)], w );
} 

// aggiunge l'item p nel dizionario (assume che la chiave p -> w non ci sia gia')
void dict_add( Dict t, Item *p ){
  int i = hash( p -> word);
  t -> array[i] = chain_insert ( t -> array[i], p );
  t -> count++;
}

void dict_print ( Dict t ) {
//    printf( "inizio printDict di punt %p\n", t );
  printf( "\n\nDICT\n" );

  for ( int i = 0; i < HASHSIZE; i++ ) {
    printf( "%d: ", i );
    chain_print( t -> array[i] );
    printf( "\n" );
  }
}






// FUNZIONI GENERICHE

void printArray ( int a[], int size) {
// printf( "inizio printArray di size %d\n", size );
  for ( int i = 0; i < size; i++ )
    printf( "%d ", a[i] );
  printf( "\n" );
}

// Lettura di una parola (solo caratteri alfanumerici) con allocazione dello spazio necessario
// modificata in modo da annotare il carattere separatore dopo il carattere di fine-stringa
// es: se la parola "ciao" e' terminata da una virgola, restituisco il vettore
// {'c', 'i', 'a', 'o', '\0', ','}
char *read_word() {
  char *w, *p, c;
  int size = N; 	// lunghezza iniziale dell'array
  int n = 0;        	// numero di caratteri letti
  w = malloc( size );
  p = w;		// per ricordare l'indirizzo del primo carattere
  
  while ( isalpha( c = getchar() ) ) {
    
    // se ho terminato lo spazio, raddoppio l'allocazione
    if ( w - p >= size ) {
      n = w - p;
      size *=2;
      p = realloc( p, size * sizeof(int) );
      w = p + n;
    }
  
    // memorizzo l'i-esimo elemento
    *w++ = tolower( c );
  }
  
  *w++ = '\0';
  *w = c;
  return p;
}


// Lettura di una riga terminata da @ e inserisce nel dizionario le parole della riga
// riceve il numero di riga corrente
void line( Dict t, int ln ) {
  char *w;
  do {
    w = read_word();
    if ( *w == '\0' )
      free(w);
    else {
      Item *p = dict_lookup( t, w );
      if ( p == NULL ) {
     	p = item_new( w, ln );
     	dict_add( t, p );
      }
      else
     	item_modify( p, ln );
    }
    
  } while ( w[strlen( w ) + 1] != '\n' );
}


