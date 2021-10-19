import java.util.*;

/** Le istanze di questa classe sono ordini di fiori che contengono
    determinati tipi di fiore e determinata quantità di essi
    @author Marco Cesana */
public class Ordine{
  /** L'oggetto di tipo "Fiore" */
  private Fiore f;
  /** La quantità di tale fiore */
  private int q;

  /** Costruisce un ordine dati un oggetto fiore e una quantità di tale fiore
      @param f: il fiore (oggetto della classe "Fiore")
      @param q: la quantità di tale fiore desiderata */
  public Ordine(Fiore f, int q){
    this.f=f;
    this.q=q;
  }

  /** Il metodo restituisce il fiore (Un oggetto)
      @return: un oggetto fiore */
  public Fiore getFiore(){
    return this.f;
  }

  /** Il metodo restituisce la quantità di fiori ordinata
      @return: la quantità */
  public int getQuantita(){
    return this.q;
  }

  /** Permette di impostare un nuovo valore del parametro "q"
      @param q: la quantità da modificare */
  public void setQuantita(int q){
    this.q=q;
  }

}
