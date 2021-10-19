#include <stdio.h>

int main(int argc, char **argv) {

	int secret;
	char buf[16];

	printf("buf: %08x secret: %08x\n", &buf, &secret);
	gets(buf); 

	if (secret == 0x4349414F) 
		printf("you win!\n\n"); 

	return 0;
}
