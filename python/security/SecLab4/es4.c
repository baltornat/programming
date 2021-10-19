#include <stdio.h>

int main(int argc, char **argv) {

	int secret;
	char buf[64];

	printf("buf: %08x secret: %08x\n", &buf, &secret);
	gets(buf);

	if (secret == 0x01020305)
		printf("you win!\n");
			
	return 0;
}