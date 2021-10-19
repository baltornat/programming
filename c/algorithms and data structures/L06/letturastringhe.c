#include <stdio.h>
#include <stdlib.h>

char *read_line(void){
	char c, *arr;
	int i=0;
	size_t dim=sizeof(char)*5;
	arr=malloc(dim);
	if(arr==NULL){
		printf("Errore nell'allocazione!");
		exit(0);
	}
	c=getchar();
	c=getchar();
	while(c!='\n'){
		if(sizeof(char)*i==dim){
			dim+=10;
			arr=realloc(arr,dim);
		}
		arr[i]=c;
		printf("%c",arr[i]);
		i++;
		c = getchar();
	}
	return arr;
}

char *read_word(void){
	char c, *arr;
	int i=0;
	size_t dim=sizeof(char)*5;
	arr=malloc(dim);
	if(arr==NULL){
		printf("Errore nell'allocazione!");
		exit(0);
	}
	c=getchar();
	c=getchar();
	while(c!=32){
		if(sizeof(char)*i==dim){
			dim+=10;
			arr=realloc(arr,dim);
		}
		arr[i]=c;
		printf("%c",arr[i]);
		i++;
		c = getchar();
	}
	return arr;
}

int main(void){
	int scelta;
	char *p;
	printf("Scegli se scrivere una stringa(1) o una parola(2): ");
	scanf("%d",&scelta);
	switch(scelta){
		case 1:	p = read_line();
			break;
		case 2: p = read_word();
			break;
		default: printf("Valore inserito non valido!");
			break;
	}
	free(p);
	return 0;
}