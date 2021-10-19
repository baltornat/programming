#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
int main(void){
	int x = fork();
	int i;
	if(x < 0){
		fprintf(stderr,"Fork failed!\n");
		exit(1);	
	}
	if(x != 0){
		for(i=0;i<5;i++)	
	       		printf("Processo padre (x == %d)\n",x);
	}else{
		for(i=0;i<5;i++)
		printf("Processo figlio (x == %d)\n",x);
	}
	return 0;
}
