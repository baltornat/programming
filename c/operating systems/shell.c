#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

void display_prompt(){
	printf("Shell $> ");
}

int main(void){
	char *command = malloc(sizeof(char));
	while(1){
		display_prompt();
		scanf("%s",command);
		if(strcmp(command,"exit")==0){
			exit(0);
		}else{
			int x = fork();
			if(x < 0){
				fprintf(stderr,"Fork failed!\n");
				exit(1);
			}else if(x == 0){
				char *args[]={"./../../../../../../../bin/ls",NULL};	
				execv(args[0],args);
			}else{
				waitpid(x, NULL, 0);
			}
		}
	}
	return 0;
}
