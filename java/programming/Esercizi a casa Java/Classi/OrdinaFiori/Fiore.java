import java.util.*;

/** Le istanze di questa classe sono Fiori che comporranno un mazzo
    @author Marco Cesana */
public class Fiore{
  /** Il nome del fiore */
  private String nome;
  /** Il prezzo unitario del fiore */
  private double prezzo;

  /** Costruisce un Fiore
      @param nome: il nome del fiore
      @param prezzo: il prezzo unitario del fiore */
  public Fiore(String nome, double prezzo){
    this.nome=nome;
    this.prezzo=prezzo;
  }

  /** Restituisce il nome del fiore
      @return: il nome del fiore */
  public String getNome(){
    return this.nome;
  }

  /** Restituisce il prezzo unitario del fiore
      @return: il prezzo unitario del fiore */
  public double getPrezzo(){
    return this.prezzo;
  }

  /** Imposta un nuovo prezzo unitario al fiore
      @param prezzo: il nuovo prezzo */
  public void setPrezzo(double prezzo){
    this.prezzo=prezzo;
  }

  /** Ridefinizione del metodo toString della classe "Object"
      Il metodo restituisce una stringa che contiene il nome
      del fiore e il suo prezzo unitario
      @return: la stringa */
  @Override
  public String toString(){
    return "Il fiore è un/una "+this.nome+" e costa "+this.prezzo+" euro.";
  }

  /** Ridefinizione del metodo equals della classe "Object"
      Il metodo restituisce valori booleani se i fiori sono uguali o diversi
      @return: false se l'istanza su cui è invocato il metodo è diversa da quella
      passata come parametro
      @return true se i due fiori sono uguali (Sia per nome che per prezzo) */
  @Override
  public boolean equals(Object altro){
    if(!(altro instanceof Fiore)){
      return false;
    }
    Fiore o=(Fiore) altro;
    return o.nome.equals(nome) && o.prezzo==prezzo;
  }

}
