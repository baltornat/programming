#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

//stampo 10 volte il padre/figlio 1/figlio 2

int main(void){
	int c1 = fork();	//creo primo figlio
	if(c1 < 0){
		fprintf(stderr,"Fork c1 failed!\n");
		exit(1);
	}else if(c1 == 0){
		for(int i=0; i<10; i++){
			printf("(pid:%d) Sono c1!\n",(int) getpid());
			sleep(1);	//faccio dormire il figlio 1
		}
	}else{
		int c2 = fork();	//creo secondo figlio
		if(c2 < 0){
			fprintf(stderr,"Fork c2 failed!\n");
			exit(1);
		}else if(c2 == 0){
			for(int i=0; i<10; i++){
				printf("(pid:%d) Sono c2!\n",(int) getpid());
				sleep(1);	//faccio dormire il figlio 2
			}
		}else{
			for(int i=0; i<10; i++){
				printf("(pid:%d) Sono il padre!\n",(int) getpid());
				sleep(1);	//faccio dormire il padre
			}
		}	
	}
	return 0;
}
