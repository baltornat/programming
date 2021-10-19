import java.util.*;

public class CalcolaGiorno{
  public static void main(String[] args){
    int giorno = Integer.parseInt(args[0]);
    int mese = Integer.parseInt(args[1]);
    int anno = Integer.parseInt(args[2]);
    int somma = 0;
    int gf = 28;
    if(isBisestile(anno)){
      gf = 29;
    }
    switch(mese){
      case 12: somma=(306+gf)+giorno;
      break;
      case 11: somma=(276+gf)+giorno;
      break;
      case 10: somma=(245+gf)+giorno;
      break;
      case 9: somma=(214+gf)+giorno;
      break;
      case 8: somma=(184+gf)+giorno;
      break;
      case 7: somma=(153+gf)+giorno;
      break;
      case 6: somma=(123+gf)+giorno;
      break;
      case 5: somma=(92+gf)+giorno;
      break;
      case 4: somma=(62+gf)+giorno;
      break;
      case 3: somma=(31+gf)+giorno;
      break;
      case 2: somma=(31+giorno);
      break;
      case 1: somma=giorno;
      break;
    }
    System.out.println(somma);
  }
  public static boolean isBisestile(int anno){
    if(anno%4==0 && (anno%100!=0 || anno%400==0))
      return true;
    return false;
  }
}
