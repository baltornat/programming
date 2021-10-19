import java.util.*;
import java.io.*;

public class DivideParoleMinMaiu{
  public static void main(String[] args){
    FileInputStream file;

    if(args.length < 1)
      return;

    try{
      file = new FileInputStream(args[0]);
    }catch(IOException ex){
      return;
    }
    Scanner in = new Scanner(file);

    ArrayList<String> min = new ArrayList<>();
    ArrayList<String> maiu = new ArrayList<>();

    while(in.hasNext()){
      String s = in.next();
      boolean num = false;
      char iniziale = s.charAt(0);
      for(int i=0; i<s.length(); i++){
        if(s.charAt(i)>='0' && s.charAt(i)<='9'){
          num = true;
        }
      }
      if(num == false && iniziale >= 'a' && iniziale <= 'z'){
        min.add(s);
      }
      if(num == false && iniziale >= 'A' && iniziale <= 'Z'){
        maiu.add(s);
      }
    }
    System.out.println("iniziano con minuscole:");
    for(int i=0; i<min.size(); i++){
      System.out.println(min.get(i));
    }
    System.out.println();
    System.out.println("iniziano con minuscole:");
    for(int i=0; i<maiu.size(); i++){
      System.out.println(maiu.get(i));
    }
  }
}
