import java.util.*;

public class NumeroBinario{
  private String binstring;
  private int binint;

  public NumeroBinario(String binstring){
    this.binstring=binstring;
  }

  public boolean isBinary(String s){
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)!='0' && s.charAt(i)!='1')
        return false;
    }
    return true;
  }

  public NumeroBinario and(NumeroBinario nb){
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<nb.binstring.length();i++){
      if(nb.binstring.charAt(i)=='0' && this.binstring.charAt(i)=='0')
        sb.append('0');
      else
        sb.append('1');
    }
    String num=sb.toString();
    NumeroBinario and=new NumeroBinario(num);
    return and;
  }

  @Override
  public String toString(){
    return this.binstring;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    System.out.print("Inserisci un numero binario: ");
    String s1=in.nextLine();
    NumeroBinario num1=new NumeroBinario(s1);
    if(num1.isBinary(s1)){
      System.out.println("E' binario!");
    }else{
      System.out.println("Non è binario!");
    }
    System.out.print("Inserisci un numero binario: ");
    String s2=in.nextLine();
    NumeroBinario num2=new NumeroBinario(s2);
    if(num2.isBinary(s2)){
      System.out.println("E' binario!");
    }else{
      System.out.println("Non è binario!");
    }

    NumeroBinario and;
    and=num1.and(num2);
    System.out.println("And tra i due numeri: "+and.toString());

  }

}
