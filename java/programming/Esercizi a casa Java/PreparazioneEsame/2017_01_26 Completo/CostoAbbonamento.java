import java.util.*;

public class CostoAbbonamento{
  public static void main(String[] args){
    char sesso = args[0].charAt(0);
    int eta = Integer.parseInt(args[1]);
    if(sesso=='m' || sesso=='M'){
      if(eta<=10)
        System.out.println("Per te abbonamento gratis");
      if(eta>=11 && eta<=25)
        System.out.println("Costo abbonamento: 10,00 euro");
      if(eta>=26 && eta<=64)
        System.out.println("Costo abbonamento: 18,50 euro");
      if(eta>=65 && eta<=75)
        System.out.println("Costo abbonamento: 10,00 euro");
      if(eta>=75)
        System.out.println("Per te abbonamento gratis");
    }
    if(sesso=='f' || sesso=='F'){
      if(eta<=14)
        System.out.println("Per te abbonamento gratis");
      if(eta>=15 && eta<=30)
        System.out.println("Costo abbonamento: 10,00 euro");
      if(eta>=31 && eta<=64)
        System.out.println("Costo abbonamento: 18,50 euro");
      if(eta>=65 && eta<=75)
        System.out.println("Costo abbonamento: 10,00 euro");
      if(eta>=75)
        System.out.println("Per te abbonamento gratis");
    }
  }
}
