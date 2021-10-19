import java.util.*;
import java.io.*;

public class TrovaRigheColonneTutteZero{
  public static void main(String[] args){
    if(args.length < 1)
     return;

    FileInputStream file;
    try{
      file = new FileInputStream(args[0]);
    }catch(IOException ex){
      return;
    }
    Scanner in = new Scanner(file);
    ArrayList<String> arr = new ArrayList<>();

    while(in.hasNext()){
      String s=in.next();
      arr.add(s);
    }
    int lungRiga = arr.get(0).length();

    System.out.println("righe tutte zero:");
    for(int i=0; i<arr.size(); i++){
      int cont = 0;
      for(int j=0; j<lungRiga; j++){
        if(arr.get(i).charAt(j)=='0'){
          cont++;
        }
      }
      if(cont==lungRiga)
        System.out.println(i+1);
    }

    System.out.println("colonne tutte zero:");
    for(int i=0; i<lungRiga; i++){
      int c = 0;
      for(int j=0; j<arr.size(); j++){
        if(arr.get(j).charAt(i)=='0'){
          c++;
        }
      }
      if(c==arr.size())
        System.out.println(i+1);
    }
  }
}
