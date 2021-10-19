#include <stdio.h>
#define N 5

int main(void){
    int mat[N][N];
    int i,j;
    float media;
    int somma=0;
    for(i=0;i<N;i++){
        printf("Inserisci i voti dello studente %d\n",i+1);
        for(j=0;j<N;j++){
            printf("Inserisci il voto %d: ",j+1);
            scanf("%d",&mat[i][j]);
        }
    }
    for(i=0;i<N;i++){
        for(j=0;j<N;j++){
            somma=somma+mat[i][j];
        }
        media=somma/(float)N;
        printf("Media dello studente %d: %f\n",i+1,media);
        somma=0;
    }
    for(i=0;i<N;i++){
        for(j=0;j<N;j++){
            somma=somma+mat[j][i];
        }
        media=somma/(float)N;
        printf("Media dei voti dell'esame %d: %f\n",i+1,media);
        somma=0;
    }
    return 0;
}