import java.util.*;

/** La classe crea un mazzo di oggetti Fiore
    @author Marco Cesana */
public class Mazzo{
  /** Un ArrayList che contiene vari ordini e costituisce il vero e proprio mazzo
      Il costruttore viene inizializzato in automatico
      Il costrutto "arr = new ArrayList<>()" è il costruttore */
  private ArrayList<Ordine> arr = new ArrayList<>();

  /** Il metodo consente di aggiungere un fiore al mazzo (viene creato un ordine
      per ogni nuovo fiore inserito e aumentata la quantità del fiore se già presente
      nel mazzo)
      @param fiore: un oggetto Fiore
      @param quantita: la quantità di tale fiore */
  public void add(Fiore fiore, int quantita){
    boolean aggiungi = true;
    for(Ordine o : arr){
      if(o.getFiore().equals(fiore)){
        o.setQuantita(o.getQuantita()+quantita);
        aggiungi = false;
      }
    }
    if(aggiungi){
      arr.add(new Ordine(fiore, quantita));
    }
  }

  /** Il metodo restituisce il prezzo del mazzo calcolato in base ai fiori di
      cui è composto e alla loro quantità
      @return: il prezzo del mazzo (double prezzoMazzo) */
  public double calcolaPrezzo(){
    double prezzoMazzo=0;
    for(Ordine o : arr){
      prezzoMazzo+=o.getQuantita()*o.getFiore().getPrezzo();
    }
    return prezzoMazzo;
  }

  /** Ridefinizione del metodo toString della classe "Object"
      Il metodo restituisce una stringa che contiene il prezzo del Mazzo
      calcolato con il metodo "calcolaPrezzo" e il tipo di fiore con
      la relativa quantità
      @return: la stringa */
  @Override
  public String toString(){
    StringBuilder sn = new StringBuilder();

    for(Ordine o : arr){
      sn.append(o.getFiore().getNome() + " quantità:"+o.getQuantita()+" ");
    }

    return sn.toString()+" costo mazzo: "+calcolaPrezzo()+" euro";
  }

}
