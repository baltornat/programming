#include <stdio.h>

int lung_stringa(char *s){
	int lung=0;
	char *p;
	p=&s[0];
	while(*p!='\0'){
		p++;
		lung++;
	}
	return lung;
}

int main(void){
	char s[100]={0};
	int lung;
	printf("Inserisci una stringa: ");
	scanf("%s",s);
	lung=lung_stringa(s);
	printf("%d",lung);
	return 0;
}