/* COMPILO CON -pthread

Produttore - Consumatore

REALIZZATO CON MONITOR */

#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

#define N 10
char *buffer[N];
int count = 0;

/* CONDITION VARIABLES */
pthread_cond_t full = PTHREAD_COND_INITIALIZER;
pthread_cond_t empty = PTHREAD_COND_INITIALIZER;

/* LOCKS */
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;

void b_insert(char *o) {
  pthread_mutex_lock(&lock);
  while(count == N) pthread_cond_wait(&full, &lock);
  printf("Inserimento in buffer con %d\n", count);
  buffer[count++] = o;
  if(count == 1) pthread_cond_signal(&empty);
  pthread_mutex_unlock(&lock);
}

void b_remove(char **result) {
  pthread_mutex_lock(&lock);
  while(count == 0) pthread_cond_wait(&empty, &lock);
  printf("Rimozione in buffer con %d\n", count);
  *result = buffer[--count];
  if(count == N-1) pthread_cond_signal(&full);
  pthread_mutex_unlock(&lock);
}

void *producer(void *nonusato) {
  printf("Esecuzione del produttore\n");
  while(1) {
    char *o = (char*)malloc(sizeof(char));
    printf("Ho prodotto %p\n", o);
    b_insert(o);
  }
}

void *consumer(void *nonusato) {
  printf("Esecuzione del consumatore\n");
  while(1) {
    char *o;
    b_remove(&o);
    free(o);
    printf("Ho consumato %p\n", o);
  }
}

int main(int argc, char *argv[]) {
  pthread_t p1, p2;
  pthread_create(&p1, NULL, consumer, NULL);
  pthread_create(&p2, NULL, producer, NULL);
  pthread_join(p1, NULL);
  pthread_join(p2, NULL);
  return 0;
}
