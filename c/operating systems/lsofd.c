#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/stat.h>
#define _USE_POSIX
#include <limits.h>

void lsofd(const char* name){
	int i;
	for(i=0; i<_POSIX_OPEN_MAX; i++){
		struct stat buf;
		if(fstat(i, &buf) == 0){
			printf("%s fd:%d i-node: %d\n", name, i, (int)buf.st_ino);
		}
	}
}

int main(){
	pid_t pid;
	int f, off;
	char string[] = "Hello, world!\n";

	lsofd("Padre (senza figli)");
	printf("Padre (senza figli) open *\n");
	f = open("provaxxx.dat", O_CREAT | O_WRONLY | O_TRUNC, S_IRWXU);
	if(f == -1){
		perror("open");
		exit(1);
	}
	lsofd("Padre (senza figli)");
	if(write(f, string, (strlen(string))) != (strlen(string))){
		perror("write");
		exit(1);
	}

	off = lseek(f, 0, SEEK_CUR);
	printf("Padre (senza figli) seek: %d\n", off);
	
	printf("Padre (senza figli) fork *\n");
	if((pid = fork()) < 0){
		perror("fork");
		exit(1);
	}

	if(pid > 0){
		lsofd("padre");
		int status;
		waitpid(pid, &status, 0);
		printf("Padre write & close *\n");
		off = lseek(f, 0, SEEK_CUR);
		printf("Padre seek prima: %d\n", off);
		if(write(f, string, (strlen(string))) != (strlen(string))){
			perror("write");
			exit(1);
		}
		lsofd("padre");
		off = lseek(f, 0, SEEK_CUR);
		printf("Padre seek dopo: %d\n", off);
		close(f);
		exit(0);
	}else{
		lsofd("figlio");
		printf("Figlio write & close *\n");
		off = lseek(f, 0, SEEK_CUR);
		printf("Figlio seek prima: %d\n", off);
		if(write(f, string, (strlen(string))) != (strlen(string))){
			perror("write");
			exit(1);
		}
		lsofd("figlio");
		off = lseek(f, 0, SEEK_CUR);
		printf("Figlio seek dopo: %d\n", off);
		close(f);
		exit(0);
	}
}
