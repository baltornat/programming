#include <stdio.h>

int main(void){
	int h1,m1,s1,h2,m2,s2,h3,m3,s3;
	int sec1, sec2, conv;
	printf("Inserisci un primo orario nel formato hh:mm:ss : ");
	scanf("%d:%d:%d",&h1,&m1,&s1);
	printf("Inserisci un secondo orario nel formato hh:mm:ss : ");
	scanf("%d:%d:%d",&h2,&m2,&s2);
	sec1 = h1*3600+m1*60+s1;
	sec2 = h2*3600+m2*60+s2;
	conv = sec1 > sec2 ? sec1-sec2 : sec2-sec1;
	h3 = conv/3600;
	m3 = (conv-h3*3600)/60;
	s3 = conv-(h3*3600)-(m3*60);
	printf("%d:%d:%d",h3,m3,s3);
	return 0;
}