import java.util.*;

public class StazioneMeteoTester{
  public static int[] riempi(String s){
      int giorno = Integer.parseInt(s.substring(0,s.indexOf(' ')).trim());
      s = s.substring(s.indexOf(' ')).trim();
      int temperatura = Integer.parseInt(s.substring(0,s.indexOf(' ')).trim());
      s = s.substring(s.indexOf(' ')).trim();
      int precipitazioni = Integer.parseInt(s);
      int[] valori = new int[3];
      valori[0] = giorno;
      valori[1] = temperatura;
      valori[2] = precipitazioni;
      return valori;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    ArrayList<Integer> arr = new ArrayList<>();
    int[] valori = new int[3];
    while(in.hasNextLine()){
      String s = in.nextLine();
      valori = riempi(s);
      arr.add(new valori);
    }
    for(int i=0; i<arr.size(); i++){
        System.out.println(arr.get(i));
    }
  }
}
