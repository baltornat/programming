#include <stdio.h>
#include <ctype.h>

int main(void){
	int r,c,i,j,cont=0;
	char mat[100][100];
	char aux;
	printf("Inserisci il numero di righe: ");
	scanf("%d",&r);
	printf("Inserisci il numero di colonne: ");
	scanf("%d",&c);
	for(i=0;i<r;i++){
		for(j=0;j<c;j++){
			printf("Riga %d, colonna %d: ",i+1,j+1);
			scanf(" %c",&mat[i][j]);
			getchar();
		}
	}
	for(i=0;i<r;i++){
		for(j=0;j<c;j++){
			printf("%c ",mat[i][j]);
		}
		printf("\n");
	}
	for(j=0;j<c;j++){
		for(i=(r-1);i>=0;i--){
			if(isalpha(mat[i][j])!=0){
				aux=mat[i][j];
				mat[i][j]='*';
				mat[(r-1)-cont][j]=aux;
				cont++;
			}
		}
		cont=0;
	}
	printf("_-_Matrice schiacciata_-_\n");
	for(i=0;i<r;i++){
		for(j=0;j<c;j++){
			printf("%c ",mat[i][j]);
		}
		printf("\n");
	}
	return 0;
}