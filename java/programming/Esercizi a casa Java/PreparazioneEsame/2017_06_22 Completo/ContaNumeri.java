import java.util.*;

public class ContaNumeri{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int interi = 0;
    int floating = 0;
    while(in.hasNext()){
      if(in.hasNextInt()){
        in.nextInt();
        interi++;
      }else{
        if(in.hasNextFloat()){
          in.nextFloat();
          floating++;
        }else{
          if(in.hasNext()){
            in.next();
          }
        }
      }
    }
    System.out.println("interi: "+interi);
    System.out.println("floating: "+floating);
  }
}
