import java.util.*;

public class Portafoglio{

  public static final int[] tagli={5,10,20,50,100,200,500};
  public static int indiceTaglio(int taglio){
    for(int i=0;i<tagli.length;i++){
      if(tagli[i]==taglio)
        return i;
    }
    return -1;
  }

  private int[] qta;
  public Portafoglio(){
    qta=new int[tagli.length];
  }

  public int valoreTotale(){
    int somma=0;
    for(int i=0; i<tagli.length;i++){
      somma+=qta[i]*tagli[i];
    }
    return somma;
  }

  public void aggiungiBanconota(int valore){
    int i=indiceTaglio(valore);
    qta[i]++;
  }

  public void paga(int x){
    for(int i=tagli.length-1;i>=0;i--)
      while(taglia[i]<=x && qta[i]>0){
        qta[i]--;
        System.out.println("Esco una banconota da "+tagli[i]);
        x-=tagli[i];
      }
  }

}
