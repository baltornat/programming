import java.util.*;
import java.io.*;

public class SortParole{
  public static void main(String[] args){
    FileInputStream file;
    try{
      file = new FileInputStream(args[0]);
    }catch(IOException ex){
      return;
    }
    Scanner in = new Scanner(file);
    ArrayList<String> arr = new ArrayList<>();
    while(in.hasNext()){
      String s = in.next();
      arr.add(s);
    }
    Collections.sort(arr);
    for(int i=0; i<arr.size(); i++){
      System.out.println(arr.get(i));
    }
  }
}
