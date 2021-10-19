/*Esercizio Filtro:
PotenzeDiDue
Descrizione
Un numero `e una potenza di due se `e pari a 1, o se si pu`o ottenere moltiplicando successivamente
2 per se stesso.
Scrivere un programma (il file DEVE chiamarsi
PotenzeDiDue.java
) che, data una sequenza
di interi positivi passata da
linea di comando
, emetta nel flusso d’uscita quanti tra essi sono
potenze di due.
Vincoli
Nel caso (possibile) in cui la sequenza in input sia vuota si stampi semplicemente il messaggio
“nessun input”.  Si assuma altrimenti che i dati in input siano nella forma attesa.
Esempi
Ecco un esempio di esecuzione
$java PotenzeDiDue 431 1 221 64 55 512
3
*/

import java.util.*;

public class Filtro5Luglio{
  public static void main(String[] args){
    boolean divisibile = true;
    int cont = 0;
    for(int i=0; i<args.length; i++){
      int n=Integer.parseInt(args[i]);
      if(n==0)
        break;
      while(n>1){
        if(n%2!=0)
          divisibile=false;
        n/=2;
      }
      if(divisibile)
        cont++;
      divisibile=true;
    }
    System.out.println(cont);
  }
}
