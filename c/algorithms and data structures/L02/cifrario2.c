#include <stdio.h>
#define N 100

int main(void){
    char c;
    char arr[N]={0};
    int k,i=0;
    printf("Inserisci una sequenza di caratteri (termina con .): ");
    do{
        c=getchar();
        if(c=='.')
            break;
        arr[i]=c;
        i++;
    }while(i<N);
    printf("Inserisci una chiave: ");
    scanf("%d",&k);
    i=0;
    do{
        if(arr[i]==0)
            break;
        if((arr[i]>64 && arr[i]<91) || (arr[i]>96 && arr[i]<123)){
            if((arr[i]+k>90 && arr[i]+k<97) || (arr[i]+k>122)){
                arr[i]=arr[i]-26+k;
                printf("%c",arr[i]);
            }else{
                arr[i]=arr[i]+k;
                printf("%c",arr[i]);
            }
        }else{
            printf(" ");
        }
        i++;
    }while(i<N);
    printf("\n");
    return 0;
}