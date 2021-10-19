import java.util.*;

public class PotenzeDiDue{
  public static void main(String[] args){
    int cont = 0;
    if(args.length < 1){
      System.out.println("nessun input");
      return;
    }
    for(int i=0; i<args.length; i++){
      int temp = Integer.parseInt(args[i]);
      boolean resto = false;
      while(temp>1){
        if(temp%2!=0){
          resto = true;
          break;
        }
        temp=temp/2;
      }
      if(resto == false)
        cont++;
    }
    System.out.println(cont);
  }
}
