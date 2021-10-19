/*  Esercizio Filtro:
reverse+reverse
1.1  Descrizione
Realizzare un programma
RevRev.java
che legga un certo numero (non noto a priori) di linee
di testo e le riproponga in output in ordine inverso (la prima riga per ultima e cos`ı via) e ogni
riga ribaltata (il primo carattere per ultimo e cos`ı via).  Ad esempio, dato l’input:
pippo        pluto
gastone
paperino
qui paperone
Si deve ottenere l’output:
enorepap iuq
onirepap
enotsag
otulp        oppip
E  NULL’ALTRO!  Non  inserire  altri  messaggi  all’utente,  la  correzione  avviene  per  confronto
diretto con l’output atteso!
1.2  Vincoli e condizioni
Si assuma che l’input contenga almeno una riga di testo non vuota.  Il numero di linee di testo
in  ingresso  “non  noto  a  priori”  implica  che  l’input  pu`o  constare  anche  di  decine,  centinaia,
migliaia, etc.  di righe.
Il file sorgente consegnato DEVE chiamarsi
RevRev.java
e contenere la classe
pubblica
RevRev
con un
main
invocabile con:
$ java RevRev
*/

import java.util.*;

public class Filtro13Febbraio{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    ArrayList<String> arr = new ArrayList<>(); //ArrayList dell'input
    ArrayList<String> inv = new ArrayList<>(); //ArrayList dell'output
    //Carico l'ArrayList dell'input
    while(in.hasNextLine()){
      String s = in.nextLine();
      arr.add(s);
    }
    /*Per ogni elemento dell'ArrayList contenente l'input creo una stringa
      (utilizzando la classe StringBuilder) contenente l'inverso di quello
      contenuto alla posizione "i" dell'ArrayList di input e la carico
      all'interno dell'ArrayList degli output */
    for(int i=0; i<arr.size(); i++){
      StringBuilder sb = new StringBuilder();
      int lung = arr.get(i).length();
      for(int j=lung-1; j>=0; j--){
        sb.append(arr.get(i).charAt(j));
      }
      String invertita = sb.toString();
      inv.add(invertita);
    }
    //Stampo l'ArrayList degli output leggendola dall'ultimo al primo elemento
    for(int i=inv.size()-1; i>=0; i--){
      System.out.println(inv.get(i));
    }

  }
}
