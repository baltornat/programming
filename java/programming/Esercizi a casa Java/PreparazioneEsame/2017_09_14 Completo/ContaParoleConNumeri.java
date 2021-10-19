import java.util.*;

public class ContaParoleConNumeri{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int contaCifre = 0;
    int paroleConCifre = 0;
    int paroleSenzaCifre = 0;
    int contaCifreTotali = 0;

    while(in.hasNext()){
      String s = in.next();
      int lung = s.length();
      for(int i=0; i<lung; i++){
        if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
          contaCifre++;
          contaCifreTotali++;
        }
      }
      if(contaCifre==0)
        paroleSenzaCifre++;
      else
        paroleConCifre++;
      contaCifre = 0;
    }
    System.out.println("parole con cifre: "+paroleConCifre);
    System.out.println("parole senza cifre: "+paroleSenzaCifre);
    System.out.println("numero totale di cifre: "+contaCifreTotali);
  }
}
