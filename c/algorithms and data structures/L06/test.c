#include<stdio.h>
#include<stdlib.h>

void *new_book(int n, char **book, int old);
void book_in(int k,char *name, char **book);
void cancel(int k, char **book);
void move(int from, int to, char **book);
void printBook(char **book, int n);
char *read_word();

int main(){
	char c, **book=NULL, *name;
	int n=0, old=0, in_out, from, to;
	while((c=getchar())!='f'){
		switch(c){
			case 'b':
				old=n;
				scanf(" %d",&n);
				book=new_book(n,book, old);
				break;
			case '+':
				scanf(" %d ",&in_out);
				if(in_out<n){
					name=read_word();
					book_in(in_out, name, book);
				}
				else
					printf("Posizione inesistente\n");
				break;
			case '-':
				scanf(" %d",&in_out);
				if(in_out<n){
					cancel(in_out, book);
				}
				else
					printf("Posizione inesistente\n");
				break;
			case 'm':
				scanf(" %d %d",&from, &to);
				if(from<n && to<n)
					move(from, to, book);
				else
					printf("Posizione inesistente\n");
				break;
			case 'p':
				if(n==0)
					printf("Registro non istanziato");
				else
					printBook(book, n);
				break;
		}
	}

	return 0;
}

void *new_book(int n, char **book, int old){
	for(int f=0; f<old; f++)
		free(*(book+f));
	free(book);
	book=malloc(n*sizeof(char *));
	if(book==NULL){
		printf("Memoria piena, impossibile creare il registro\n");
		return NULL;
	}
	else{
		for(int i=0; i<n; i++)
			*(book+i)=NULL;
		return book;
		printf("Nuovo registro istanziato\n");
	}
}

void book_in(int k,char *name, char **book){
	if(book==NULL){
		printf("Non hai ancora creato un registro\n");
	}
	else{
		if(*(book+k)==NULL){
			*(book+k)=name;
		}
		else
			printf("Posizione già prenotata\n");
	}

}

void cancel(int k, char **book){
	if(book==NULL){
		printf("Non hai ancora creato un registro\n");
	}
	else{
		if(*(book+k)==NULL)
			printf("Posizione già vuota\n");
		else{
			free(*(book+k));
			*(book+k)=NULL;
		}
	}
}

void move(int from, int to, char **book){
	if(*(book+from)!=NULL && *(book+to)==NULL){
		*(book+to)=*(book+from);
		*(book+from)=NULL;
		printf("Spostato\n");
	}
}

void printBook(char **book, int n){
	int vuoto=0;
	for(int i=0; i<n; i++){
		if(*(book+i)!=NULL){
			printf("%d--->%s",i,*(book+i));
			vuoto++;
			printf("--%p\n",book+i);
		}
	}
	if(vuoto==0)
		printf("Registro vuoto\n");
}

char *read_word(){
	char *p, c, index=0, size=10;
	p=malloc(size*sizeof(char));
	while((c=getchar())!='\n'){
		if(index<size){
			*(p+index)=c;
			index++;
		}
		else{
			size+=10;
			p=realloc(p,size*sizeof(char));
		}
	}

	if(index+1<size)
		*(p+index+1)='\0';
	else{
		p=realloc(p, (index+1)*sizeof(char));
		*(p+index+1)='\0';
	}
	return p;
}