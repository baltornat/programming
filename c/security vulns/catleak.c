#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

void main(){
	int fd;
	char *v[2];
	fd = open("/etc/zzz", O_RDWR | O_APPEND);
	if(fd == -1){
		printf("Non posso aprire il file\n");
		exit(0);
	}
	printf("Valore fd = %d\n", fd);
	setuid(getuid());
	v[0] = "/bin/sh";
	v[1] = 0;
	execve(v[0], v, 0);
}
