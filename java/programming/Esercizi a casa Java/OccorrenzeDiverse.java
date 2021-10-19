import java.util.*;

public class OccorrenzeDiverse{
  public static void main(String[] args){
      Scanner in=new Scanner(System.in);
      System.out.print("Inserisci un numero telefonico: ");
      String numeroTelefono=in.nextLine();
      int[] occorrenza=new int[10];
      for(int i=0;i<10;i++){
        occorrenza[i]=0;
      }
      for(int i=0;i<10;i++){
        int n=Character.getNumericValue(numeroTelefono.charAt(i));
        occorrenza[n]=occorrenza[n]+1;
      }
      System.out.println("Stampo le occorrenze: ");
      for(int i=0;i<10;i++){
        System.out.println("Occorrenza del numero "+i+": "+occorrenza[i]);
      }
  }
}
