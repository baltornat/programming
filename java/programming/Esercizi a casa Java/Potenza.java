import java.util.*;

public class Potenza{
  public static void main(String[] args){
      Scanner in=new Scanner(System.in);
      System.out.print("Inserisci una base: ");
      int base=in.nextInt();
      System.out.print("Inserisci l'esponente: ");
      int exp=in.nextInt();
      System.out.println("Risultato: "+potenza(base,exp));
  }

  public static int potenza(int base, int exp){
    if(exp==1){
      return base;
    }else{
      return base*potenza(base, exp-1);
    }
  }
}
