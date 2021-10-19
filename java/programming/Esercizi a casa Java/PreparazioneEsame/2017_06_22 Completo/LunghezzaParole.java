import java.util.*;

public class LunghezzaParole{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int min = Integer.MAX_VALUE;
    int max = 0;
    int numeroParole = 0;
    int lunghezzaTotale = 0;
    while(in.hasNext()){
      String s = in.next();
      lunghezzaTotale += s.length();
      numeroParole++;
      if(s.length()<min)
        min = s.length();
      if(s.length()>max)
        max = s.length();
    }
    System.out.println("max: "+max);
    System.out.println("med: "+(lunghezzaTotale/numeroParole));
    System.out.println("min: "+min);
  }
}
