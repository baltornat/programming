import java.util.*;

public class PoorMansHash{
  public static void main(String[] args){
    String input = args[0];
    StringBuilder sb = new StringBuilder("               ");
    for(int i=0; i<input.length(); i++){
      char c = (char)(input.charAt(i)/3);
      int k = i%15;
      char cpiuk = (char)(c+sb.charAt(k));
      char charout = (char)((cpiuk%95)+33);
      sb.setCharAt(k,charout);
    }
    String output = sb.toString();
    System.out.println(output);
  }
}
