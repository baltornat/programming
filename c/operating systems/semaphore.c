/* COMPILO CON -pthread

A deve stampare prima di 2
1 deve stampare prima di B */


#include <stdio.h>
#include <semaphore.h>
#include <pthread.h>
#include <stdlib.h>
#include <assert.h>     //per gestire gli errori

sem_t s1, s2;
int errori = 0;

void *run_nums(void *p) {
  printf("statement1\n");
  sem_post(&s1);
  sem_wait(&s2);
  printf("statement2\n");
  return NULL;
}

void *run_letters(void *p) {
  printf("statementA\n");
  sem_post(&s2);
  sem_wait(&s1);
  printf("statementB\n");
  return NULL;
}

int main(int argc, char *argv[]) {
  pthread_t p1, p2;
  errori = sem_init(&s1, 0, 0); //assert non necessaria! -> sem_init(...);
  assert(errori != -1);         //se non ci sono errori prosegue, altrimenti abortisce
  errori = sem_init(&s2, 0, 0);
  assert(errori != -1);
  pthread_create(&p1, NULL, run_nums, NULL);
  pthread_create(&p2, NULL, run_letters, NULL);
  pthread_join(p1, NULL);
  pthread_join(p2, NULL);
  return 0;
}
