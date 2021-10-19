#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char **newBook(int n){
	size_t dim=sizeof(char **)*n;
	char **p;
	p=malloc(dim);
	if(p==NULL){
		printf("Errore durante l'allocazione!\n");
		exit(0);
	}
	for(int i=0;i<n;i++){
		p[i]=NULL;
	}
	return p;
}

char *book(int k,char *nome,char **p){
	int lung = strlen(nome);
	int i;
	char *w;
	if(p[k]==NULL){
		w=malloc(sizeof(char *)*(lung+1));
		if(w==NULL){
			printf("Errore durante l'allocazione del nome!\n");
			exit(0);
		}
		p[k]=w;
		for(i=0;i<lung;i++){
			w[i]=nome[i];
		}
		w[i]='\0';
		return w;
	}else{
		printf("Errore: Posto già occupato!\n");
		return p[k];
	}
}

void printBook(int n,char **arr){
	char *w,c;
	int j=0,i;
	printf("REGISTER[0...%d]:\n",n-1);
	//Provo a printare l'array dei puntatori
	/*for(i=0;i<n;i++){
		printf("%p\n",arr[i]);
	}*/
	for(i=0;i<n;i++){
		w=arr[i];
		if(w!=NULL){
			c=w[j];
			printf("%d --> ",i);
			while(c!='\0'){
				printf("%c",c);
				j++;
				c=w[j];
			}
			printf("\n");
			j=0;
		}
	}
}

void cancella(int k,char **p,char **arr){
	if(p[k]!=NULL){
		free(p[k]);
		p[k]=NULL;
		arr[k]=NULL;
	}else{
		printf("Posizione già vuota!\n");
	}
}

void move(int from,int to,char **p,char **arr){
	char *w;
	if(p[to]==NULL){
		if(p[from]!=NULL){
			w=p[from];
			p[to]=w;
			arr[to]=w;
			cancella(from,p,arr);
		}else{
			printf("La posizione %d è vuota!\n",from);
		}
	}else{
		printf("Posizione già occupata!\n");
	}
}

int main(void){
	char c,**p,*w;
	int n,k,from,to;
	char *arr[n];
	char nome[15];
	while((c=getchar())!='f'){
		switch(c){
			case 'b':
				getchar();
				scanf("%d",&n);
				p=newBook(n);
				break;
			case '+':
				getchar();
				scanf("%d",&k);
				getchar();
				scanf("%s",nome);
				w=book(k,nome,p);
				arr[k]=w;
				for(int i=0;i<10;i++){
					printf("%d\n",i);
				}
				break;
			case '-':
				getchar();
				scanf("%d",&k);
				cancella(k,p,arr);
				break;
			/*case 'm':
				getchar();
				scanf("%d",&from);
				getchar();
				scanf("%d",&to);
				move(from,to,p,arr);
				break;*/
			case 'p':
				printBook(n,arr);
				break;
		}
	}
	for(int i=0;i<n;i++){
		free(p[i]);
	}
	free(p);
	return 0;
}