//catall file;/bin/sh to open a root shell

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char *argv[]){
	char *cat = "/bin/cat";
	if(argc < 2){
		printf("Inserisci il nome del file\n");
		return 1;
	}
	char *command = malloc(strlen(cat)+strlen(argv[1])+2);
	sprintf(command, "%s %s", cat, argv[1]);
	system(command);
	return 0;
}
