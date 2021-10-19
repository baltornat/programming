#include <stdio.h>

void split_time(long int tot_sec,int *h,int *m,int *s){
	*s=tot_sec%60;
	tot_sec=tot_sec/60;
	*m=tot_sec%60;
	tot_sec=tot_sec/60;
	*h=tot_sec%60;
}

int main(void){
	long int tot_sec;
	int h,m,s;
	printf("Inserisci il numero di secondi trascorsi dalla mezzanotte: ");
	scanf("%ld",&tot_sec);
	split_time(tot_sec,&h,&m,&s);
	printf("\n%d:%d:%d",h,m,s);
	return 0;
}