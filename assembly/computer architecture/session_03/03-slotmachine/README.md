# Semplice slotmachine con le syscall

**WARNING : Questo sorgente è eseguibile solo con l'emulatore MARS**

*nome del file sorgente: slotmachine.asm*

Utilizzando le syscall rese disponibili dall'emulatore MARS implementare un programma che:

* Richieda all'utente attraverso una finestra di dialogo l'inserimento di un numero intero `NUM`
* Estragga un numero casuale `R` nel range `[-NUM,NUM]`, (il seed del generatore di numeri casuali può essere inizializzato con un qualsiasi numero intero)
* Sommi R al numero inserito `NUM` : `RESULT = NUM + R`
* Mostri all'utente attraverso una nuova finestra di dialogo il nuovo credito dell'utente dopo la scommessa `RESULT`.
* Il programma dovrà terminare in maniera "pulita" restituendo il controllo al sistema operativo