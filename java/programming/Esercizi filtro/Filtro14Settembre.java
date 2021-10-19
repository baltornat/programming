/*Esercizio Filtro:
lunghezze di parole
Descrizione
Scrivere una applicazione (una classe “LunghezzeParole” dotata del metodo
main
) che,  dato
un certo numero (non noto a priori) di parole su standard input (separate da “whitespace”,
cio`e spazi, tab, enter, ecc.), visualizzi su standard output il numero massimo, medio (troncato
all’intero) e minimo di caratteri presenti nelle parole in input (per il formato di output si vedano
gli esempi pi`u sotto).
Vincoli
Si assuma che l’input contenga almeno una riga di testo non vuota.  L’input termina con
fine
file
(i.e., in sistemi Linux la pressione simultanea dei tasti “Ctrl” e “d” su riga vuota se provate
il programma da shell prompt).  Il numero di parole presenti in input non `e noto a priori e pu`o
essere disposto su pi`u righe anch’esso non noto a priori.
Il file sorgente consegnato DEVE chiamarsi
LunghezzeParole.java
e contenere la classe
pub-
blica
LunghezzeParole
con un
main
invocabile con:
$ java LunghezzeParole
Esempi
Ad esempio se l’input fosse
abab    cdcd        efefefe
ggg hihih mnomnomno

l’output dovrebbe essere il seguente:
max: 9
med: 5
min: 3
*/

import java.util.*;

public class Filtro14Settembre{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int max = 0;
    int media = 0;
    int min = Integer.MAX_VALUE;
    int contaParole = 0;
    int sommaLunghezzaParole = 0;
    while(in.hasNext()){
      String s = in.next();
      int lunghezza = s.length();
      if(lunghezza > max)
        max = lunghezza;
      if(lunghezza < min)
        min = lunghezza;
      contaParole++;
      sommaLunghezzaParole+=lunghezza;
    }
    System.out.println("max: "+max);
    System.out.println("med: "+sommaLunghezzaParole/contaParole);
    System.out.println("min: "+min);
  }
}
