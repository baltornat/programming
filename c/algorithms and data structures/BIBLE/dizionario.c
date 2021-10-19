/**********************************/
/*PROGRAMMA COMPLETO SU DIZIONARIO*/
/**********************************/

#define HASHSIZE 10
//Strutture dati
typedef struct{
	char *word;
	int *ln_arr;
	int len;
	int count;
}Item;

typedef struct element *Chain;

struct element{
	Item *item;
	struct element *next;
};

typedef struct ht{
	Chain array[HASHSIZE];
	int count;
	int line;
}*Dict;

//FUNZIONE HASH
unsigned long hash(char *str);

//FUNZIONI ITEM
Item *item_new(char *w, int ln);
void print_item(Item *item);
void item_modify(Item *item, int ln); 

//FUNZIONI CHAIN
Item *chain_find(Chain c, char *w);
void print_chain(Chain c);
Chain chain_insert(Dict d, Chain c, Item *p);

//FUNZIONE DICT
Dict dict_init();
void dict_add(Dict d, Item *p);
void print_dict(Dict d);
Item *dict_lookup(Dict d, char *w);

//FUNZIONI DI INPUT/OUTPUT
char *read_word(int *end);
void read_line(Dict d);

int main(){
	Dict d=dict_init();
	int x=1;
	char scelta;
	char *ricerca;
	scelta=getchar();
	while(scelta!='f'){
		switch(scelta){
			case '+':
				scelta=getchar();
				read_line(d);
				break;
			case 'l':
				printf("Righe lette: %d\n", d->line-1);
				break;
			case 'n':
				printf("Parole distinte: %d\n", d->count-1);
				break;
			case 'p':
				print_dict(d);
				break;
			case '?':
				scelta=getchar();
				ricerca=read_word(&x);
				print_item(chain_find(d->array[hash(ricerca)], ricerca));
				break;
		}
		scelta=getchar();
	}
	//print_dict(d);
	return 0;
}

unsigned long hash(char *str){
	unsigned long hash=5381;
	int c;
	while((c=*str++))
	hash=((hash<<5)+hash)+c;/*hash * 33+c*/
	return hash%HASHSIZE;
}

//Creo un nuovo item con la prima parola inserita
Item *item_new(char *w, int ln){
	Item *p=malloc(sizeof(Item));
	p->word=w;
	p->len=10;
	p->ln_arr=calloc(p->len,sizeof(int));
	p->ln_arr[0]=ln;
	p->count=1;
	return p;
}

void print_item(Item *item){
	printf("%s: ", item->word);
	for(int i=0; i<item->count; i++)
		printf(" %d",item->ln_arr[i]);
	printf("\n");
}

//Se la lunghezza è massima rialloco e inserisco il nuovo elemento
void item_modify(Item *item, int ln){
	if(item->len==item->count){
		item->len*=2;
		item->ln_arr=realloc(item->ln_arr, item->len);
		
	}
	item->ln_arr[item->count]=ln;
	item->count++;
}

//Scorro e trovo l'elemento
Item *chain_find(Chain c, char *w){
	Chain supp=c;
	while(supp){
		if(strcmp(supp->item->word, w)==0)
			return supp->item;
		supp=supp->next;
	}
	return NULL;
}

void print_chain(Chain c){
	Chain supp=c;
	while(supp){
		print_item(supp->item);
		supp=supp->next;
	}
}

//Crea un nuovo elemento, lo inizializza e lo inserisce in testa alla catena passata
Chain chain_insert(Dict d, Chain c, Item *p){
	Chain supp=c;

	while(supp!=NULL){
		//Se trova un elemento che contiene già la parola lo aggiorna
		if(strcmp(supp->item->word, p->word)==0){
			//Se c'è già la linea corrente ritorna la catena
			for(int i=0; i<c->item->count; i++){
				if(c->item->ln_arr[i]==p->ln_arr[0]){
					return c;
				}
			}
			//se non trova la linea la aggiunge e ritorna c
			item_modify(supp->item, p->ln_arr[0]);
			return c;
		}
		supp=supp->next;
	}
	struct element *temp=malloc(sizeof(struct element));
	temp->item=p;
	temp->next=c;
	d->count++;
	return temp;
}

//Inizializza il dizionario
Dict dict_init(){
	Dict temp=malloc(sizeof(struct ht));
	temp->count=0;
	temp->line=1;
	for(int i=0; i<HASHSIZE; i++){
		temp->array[i]=NULL;
	}
	return temp;
}

//Trovo la posizione e poi inserisco l'elemento in testa alla catena nella posizione indicata
void dict_add(Dict d, Item *p){
	unsigned long pos=hash(p->word);
	d->array[pos]=chain_insert(d,d->array[pos], p);
}

void print_dict(Dict d){
	printf("Parole: %d\n", d->count);
	for(int i=0; i<HASHSIZE; i++){
		if(d->array[i]!=NULL)
			print_chain(d->array[i]);
	}
}

Item *dict_lookup(Dict d, char *w){
	unsigned long pos=hash(w);
	return chain_find(d->array[pos],w);
}

char *read_word(int *end){
	int len=2, count=0;
	char *w=malloc(len*sizeof(char));
	char c;
	while((c=getchar())!=' '){
		if(c=='\n'){
			*end=1;
			break;
		}
		if(!isalpha(c))
			break;

		if(count==len){
			len*=2;
			w=realloc(w,len);
		}
		w[count]=c;
		count++;
	}
	if(count+1<len){
		w[count+1]='\0';
		w=realloc(w,count+1);
	}
	else{
		w=realloc(w,count+1);
		w[count+1]='\0';
	}
	return w;
}

void read_line(Dict d){
	int ln=d->line;
	int end=0;
	char *w;
	Item *p;
	while(1){
		w=read_word(&end);
		p = item_new(w, ln);
		if(end==1){
			dict_add(d, p);
			d->line++;
			break;
		}
		else
			dict_add(d, p);
	}
}