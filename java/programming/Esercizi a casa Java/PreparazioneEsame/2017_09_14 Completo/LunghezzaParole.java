import java.util.*;

public class LunghezzaParole{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int max_char = 0;
    int min_char = Integer.MAX_VALUE;
    int num_tot = 0;
    int num_word = 0;

    while(in.hasNext()){ //cicla finchè c'è una parola nel Buffer
      String s = in.next().trim(); //in.next() prende la prossima parola e .trim() leva gli spazi all'inizio e alla fine di una stringa
      int num_char = s.length();
      if(max_char < num_char)
        max_char = num_char;
      if(min_char > num_char)
        min_char = num_char;
      num_tot += num_char;
      num_word ++;
    }
    System.out.println("max: "+ max_char);
    System.out.println("med: "+ num_tot/num_word);
    System.out.println("min: "+ min_char);

  }
}
