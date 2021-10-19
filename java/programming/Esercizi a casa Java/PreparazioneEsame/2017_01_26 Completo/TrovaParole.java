import java.util.*;

public class TrovaParole{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    boolean[] arr = new boolean[args.length];
    while(in.hasNext()){
      String s = in.next();
      for(int i=0; i<args.length; i++){
        if(args[i].length()==s.length()){
          arr[i]=true;
        }
      }
    }
    for(int i=0; i<arr.length; i++){
      if(arr[i])
        System.out.println(args[i]+":+");
      else
        System.out.println(args[i]+":0");
    }
  }
}
