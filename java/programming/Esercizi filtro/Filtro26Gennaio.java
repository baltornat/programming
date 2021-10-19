/*  ESERCIZIO FILTRO
Scrivere  una  applicazione  (una  classe  “ContaVocali”  dotata  del  metodo  main)  che,  dato  un
elenco  di  parole  da  standard  input,  stampi  su  standard  output  il  numero  medio  (troncato
all’intero) e massimo di vocali (eventualmente ripetute) presenti nelle parole in ingresso.
Ad esempio se l’input fosse
dfgr  ciao aiuola
aaa   paolo     dinosauro
l’output dovrebbe essere il seguente
media:3
max:5
*/

import java.util.*;

public class Filtro26Gennaio{
  public static void main(String[] args){
    int med = 0;
    int max = 0;
    int contaNumeroVocali = 0;
    int vocaliTotali = 0;
    int contaNumeroParole = 0;
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      String s = in.next();
      contaNumeroParole++;
      for(int i=0; i<s.length(); i++){
        if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
          contaNumeroVocali++;
          vocaliTotali++;
        }
      }
      if(contaNumeroVocali>max)
        max = contaNumeroVocali;
      contaNumeroVocali = 0;
    }
    System.out.println("media:"+vocaliTotali/contaNumeroParole);
    System.out.println("max:"+max);
  }
}
