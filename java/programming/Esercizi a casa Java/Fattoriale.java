import java.util.*;

public class Fattoriale{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Inserisci un numero intero: ");
    int n=in.nextInt();
    System.out.println("Il fattoriale è: "+fattoriale(n));
  }

  public static int fattoriale(int n){
    if(n==0){
      return 1;
    }else{
      return n*fattoriale(n-1);
    }
  }
}
