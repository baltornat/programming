import java.util.*;

public class RevRev{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    ArrayList<String> al = new ArrayList<>();
    while(in.hasNextLine()){
      String s = in.nextLine();
      int lung = s.length();
      StringBuilder sb = new StringBuilder(lung);
      char[] arr = new char[lung];
      for(int i=0; i<lung; i++){
        arr[i]= s.charAt(i);
      }
      for(int i=lung-1; i>=0; i--){
        sb.append(arr[i]);
      }
      al.add(sb.toString());
    }
    for(int i=al.size()-1; i>=0; i--){
      System.out.println(al.get(i));
    }
  }
}
