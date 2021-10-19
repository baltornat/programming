/* COMPILO CON -pthread

A deve stampare prima di 2
1 deve stampare prima di B

REALIZZATO CON MONITOR */

#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

/* CONDITION VARIABLES */
pthread_cond_t done1 = PTHREAD_COND_INITIALIZER;
pthread_cond_t doneA = PTHREAD_COND_INITIALIZER;

/* LOCKS */
pthread_mutex_t m1 = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mA = PTHREAD_MUTEX_INITIALIZER;

int is_1_done = 0, is_A_done = 0;

void *run_nums(void *p) {
  printf("statement1\n");
  /* FACCIO PARTIRE IL PRIMO MONITOR */
  pthread_mutex_lock(&m1),
  is_1_done = 1;
  pthread_cond_signal(&done1);
  pthread_mutex_unlock(&m1);

  /* METTO IN ATTESA IL SECONDO MONITOR */
  pthread_mutex_lock(&mA);
  while(!is_A_done){
    pthread_cond_wait(&doneA, &mA);
  }
  pthread_mutex_unlock(&mA);
  printf("statement2\n");
  return NULL;
}

void *run_letters(void *p) {
  printf("statementA\n");
  /* FACCIO PARTIRE IL SECONDO MONITOR */
  pthread_mutex_lock(&mA),
  is_A_done = 1;
  pthread_cond_signal(&doneA);
  pthread_mutex_unlock(&mA);

  /* METTO IN ATTESA IL PRIMO MONITOR */
  pthread_mutex_lock(&m1);
  while(!is_1_done){
    pthread_cond_wait(&done1, &m1);
  }
  pthread_mutex_unlock(&m1);
  printf("statementB\n");
  return NULL;
}

int main(int argc, char *argv[]) {
  pthread_t p1, p2;
  pthread_create(&p1, NULL, run_nums, NULL);
  pthread_create(&p2, NULL, run_letters, NULL);
  pthread_join(p1, NULL);
  pthread_join(p2, NULL);
  return 0;
}
