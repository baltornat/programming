import java.util.*;
import java.io.*;

public class SortParole{
  public static void main(String[] args){
    if(args.length < 1)
     return;

    FileInputStream s;
    try{
      s = new FileInputStream(args[0]);
    }catch(IOException ex){
      return;
    }
    Scanner in = new Scanner(s);
    ArrayList<String> arr = new ArrayList<>();

    while(in.hasNext()){
      String parola = in.next();
      arr.add(parola);
    }
    Collections.sort(arr);

    for(int i=0; i < arr.size(); i++)
      System.out.println(arr.get(i));
  }
}
