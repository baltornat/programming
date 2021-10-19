import java.util.*;

public class Triangolo{
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    int triangolare = Triangolare(n);
    System.out.println("Triangolare: "+ triangolare);
  }
  public static int Triangolare(int n){
    if(n==0)
      return 0;
    n += Triangolare(n-1);
    return n;
  }
}
