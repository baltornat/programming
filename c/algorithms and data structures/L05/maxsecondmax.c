#include <stdio.h>

void max_secondmax(int a[],int n,int *max,int *second_max){
	*max=0;
	*second_max=0;
	for(int i=0;i<n;i++){
		if(a[i]>=*max){
			*second_max=*max;
			*max=a[i];
		}
		if(a[i]<*max && a[i]>*second_max){
			*second_max=a[i];
		}
	}
}

void stampa(int a[],int n){
	int i;
	for(i=0;i<n;i++){
		printf("Elemento %d -> %d\n",i+1,a[i]);
	}
}

int main(void){
	int a[100]={0};
	int n;
	int max,second_max;
	printf("Quanti elementi vuoi inserire? ");
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		printf("Inserisci elemento %d: ",i+1);
		scanf("%d",&a[i]);
	}
	stampa(a,n);
	max_secondmax(a,n,&max,&second_max);
	printf("%d,%d",second_max,max);
	return 0;
}