#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

void main(){
	char *v[3];
	if(argc < 2){
		printf("Inserisci il nome del file\n");
		return 1;
	}
	v[0] = "/bin/cat";
	v[1] = argv[1];
	v[2] = 0;
	execve(v[0], v, 0);
	return 0;
}
