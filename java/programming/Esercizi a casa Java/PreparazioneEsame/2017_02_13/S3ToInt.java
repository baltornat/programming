import java.util.*;

public class S3ToInt{
  public static void main(String[] args){
    String s = args[0];
    boolean diverso=false;
    int lung = s.length();
    int exp = lung-1;
    int num = 0;
    for(int i=0; i<lung; i++){
      if(s.charAt(i)!='z' && s.charAt(i)!='u' && s.charAt(i)!='d')
        diverso=true;
    }
    if(diverso==true){
      System.out.println("input non valido");
    }else{
      for(int i=0; i<lung; i++){

        switch (s.charAt(i)){
          case 'z': num = num + (calcolaPotenza3(exp)*0);
            break;
          case 'u': num = num + (calcolaPotenza3(exp)*1);
            break;
          case 'd': num = num + (calcolaPotenza3(exp)*2);
            break;
        }
        exp--;
      }
      System.out.println(num);
    }
  }

  public static int calcolaPotenza3(int exp){
    int valore = 3;
    if(exp==1)
      return 3;
    if(exp==0)
      return 1;
    for(int i=1; i<exp; i++){
      valore = valore*3;
    }
    return valore;
  }
}
