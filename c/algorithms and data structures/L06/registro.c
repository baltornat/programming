#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void *newBook(int n){
	char **p;
	p=malloc(sizeof(char *)*n);
	for(int i=0;i<n;i++){
		*(p+i)=NULL;
	}
	return p;
}

void book(int k, char **p, char *name){
	if(*(p+k)==NULL){
		*(p+k)=name;
	}else{
		printf("Posto già occupato!\n");
	}
}

void printBook(int n, char **p){
	printf("REGISTRO[0...%d]:\n",n);
	for(int i=0;i<n;i++){
		if(*(p+i)!=NULL){
			printf("Posizione %d --> %s\n",i,*(p+i));
		}
	}
}

/*void cancel(int k, char *p){
	if(p[k]!=NULL){
		free(p[k]);
	}else{
		printf("Posto già vuoto!\n");
	}
}*/

/*void move(){
}*/

char *readWord(){
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
}

int main(void){
	char c,**p=NULL,*name;
	int n,k;
	while((c=getchar())!='f'){
		switch(c){
			case 'b':
				scanf(" %d",&n);
				if(p!=NULL){
					free(p);
					p=newBook(n);
				}else{
					p=newBook(n);
				}
				break;
			case '+':
				scanf(" %d",&k);
				name=readWord();
				book(k,p,name);
				break;
			/*case '-':
				scanf(" %d",&k);
				cancel(k,p);
				break;
			case 'm':
			
				break;*/
			case 'p':
				printBook(n,p);
				break;
		}
	}
	return 0;
}