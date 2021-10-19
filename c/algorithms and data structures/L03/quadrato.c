#include <stdio.h>

void quadrato(int n){
	int q[n][n];
	int i,auxr,auxc;
	for(i=0;i<n;i++){
		for(int j=0; j<n;j++){
			q[i][j]=0;
		}
	}
	int r=0,c=(n/2);
	q[r][c]=1;
	for(i=2;i<=(n*n);i++){
		auxr=r;
		auxc=c;
		if((r-1)<0){
			r=n-1;
		}else{
			r=r-1;
		}
		if((c+1)>=n){
			c=0;
		}else{
			c=c+1;
		}
		if(q[r][c]!=0){
			r=auxr+1;
			c=auxc;
		}
		q[r][c]=i;
	}
	for(i=0;i<n;i++){
		for(int j=0;j<n;j++){
			printf("%d\t",q[i][j]);
		}
		printf("\n");
	}
}

int main(void){
	int n;
	printf("Inserisci un numero dispari: ");
	scanf("%d",&n);
	quadrato(n);
	return 0;
}