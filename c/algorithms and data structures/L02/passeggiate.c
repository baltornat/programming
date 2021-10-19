#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main(void){
	char mat[10][10]={'.'};
	srand(time(NULL));
	int i,j,cont=65,n;
	for(i=0;i<10;i++){
		for(j=0;j<10;j++){
			mat[i][j]='.';
		}
	}
	i=0;
	j=0;
	do{
		n=rand()%4;
		switch(n){
			case 0: if((i-1)>=0 && mat[i-1][j]=='.'){
						mat[i-1][j]=cont;
						i--;
						cont++;
					}else{
						continue;
					}
			case 1:	if((i+1)<=10 && mat[i+1][j]=='.'){
						mat[i+1][j]=cont;
						i++;
						cont++;
					}else{
						continue;
					}
			case 2:	if((j-1)>=0 && mat[i][j-1]=='.'){
						mat[i][j-1]=cont;
						j--;
						cont++;
					}else{
						continue;
					}
			case 3:	if((j+1)<=10 && mat[i][j+1]=='.'){
						mat[i][j+1]=cont;
						j++;
						cont++;
					}else{
						continue;
					}
			default: 
				break;
		}
	}while(cont<91);



	for(i=0;i<10;i++){
		for(j=0;j<10;j++){
			printf("%c",mat[i][j]);
		}
		printf("\n");
	}
	return 0;
}