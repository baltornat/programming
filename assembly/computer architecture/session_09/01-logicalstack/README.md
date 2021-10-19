# Implementazione di uno stack logico mediante allocazione dinamica della memoria

*nome del file sorgente logicalstack.asm*

Si implementi una struttura dati di tipo stack (LIFO) che permetta di salvare in memoria dinamicamente strutture del tipo:
```c
struct{
	int x;
	int y;
	int angle;
	int *next;
}
``` 

Si implementino in particolare le funzioni:

- `stack_push(x,y,angle)` che inserisca un elemento nello stack 
- `stack_pop()` che rimuova un elemento dallo stack e lo restituisca all'utente (si restituisca 0 nel caso di stack vuoto)
- `stack_print()` che stampi l'intero contenuto dello stack

**Suggerimento:** si utilizzi la syscall `sbrk` per l'allocazione dinamica della memoria.