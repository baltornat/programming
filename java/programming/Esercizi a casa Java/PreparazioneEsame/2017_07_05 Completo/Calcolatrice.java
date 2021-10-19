import java.util.*;

public class Calcolatrice{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    double acc=0;
    while(in.hasNext()){
      String s = in.nextLine();
      if(s.equals("E"))
        break;
      char operatore = s.charAt(0);
      double numero = Double.parseDouble(s.substring(2));
      switch(operatore){
        case '+': acc+=numero;
        break;
        case '-': acc-=numero;
        break;
        case '*': acc*=numero;
        break;
        case '/': acc/=numero;
        break;
        case 'S': acc=numero;
        break;
      }
      System.out.println("= "+Double.toString(acc));
    }
  }
}
