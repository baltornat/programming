import java.util.*;

public class ContaVocali{
  public static void main(String[] args){
    int numeroMax = 0;
    int totParole = 0;
    int numVocali = 0;
    int cont=0;
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      String s = in.next();
      totParole++;
      for(int i=0; i<s.length(); i++){
        if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
          numVocali++;
          cont++;
        }
      }
      if(numeroMax<cont){
        numeroMax=cont;
      }
      cont=0;
    }
    System.out.println("media:"+(int)(numVocali/totParole));
    System.out.println("max:"+numeroMax);
  }
}
