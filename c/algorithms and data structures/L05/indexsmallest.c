#include <stdio.h>
#include <string.h>

int smallest_word_index(char *s[],int n){
	int index;
	char min[100];
	strcpy(min,s[0]);
	for(int i=1;i<n;i++){
		if(strcmp(min,s[i])>0){	
			strcpy(min,s[i]);
			index=i;
		}
	}
	return index;
}

int main(void){
	char *dict[7]={"ciao","mondo","come","funziona","bene","questo","programma"};
	int lung=7,pos;
	pos=smallest_word_index(dict,lung);
	printf("La parola minima si trova in posizione %d.\n",pos);
	return 0;
}