import java.util.*;

public class Autostrada{
  private int limite;
  private float lunghezza, tariffaBase, potenzaMinimaPerAccedere;
  private HashMap<Auto, Biglietto> arr = new HashMap<>(); //Si tratta di una ArrayList con sia indice che contenuto = a oggetti

  public Autostrada(int limite, float lunghezza, float tariffaBase, float potenzaMinimaPerAccedere){
    this.limite=limite;
    this.lunghezza=lunghezza;
    this.tariffaBase=tariffaBase;
    this.potenzaMinimaPerAccedere=potenzaMinimaPerAccedere;
  }

  public int getLimite(){
    return this.limite;
  }

  public float getLunghezza(){
    return this.lunghezza;
  }

  public float getTariffaBase(){
    return this.tariffaBase;
  }

  public float getPotenzaMinimaPerAccedere(){
    return this.potenzaMinimaPerAccedere;
  }

  public float orePercorrenzaVelocitaCodice(){
    float orePercorrenza = this.lunghezza/this.limite;
    return orePercorrenza;
  }

  public float velocitaMedia(float percorrenza){
    float ore = (percorrenza/60)/60;
    float velocitaMedia = this.lunghezza/ore;
    return velocitaMedia;
  }

  public boolean superatoLimite(float percorrenza){
    float velocitaMedia = velocitaMedia(percorrenza);
    if(velocitaMedia>this.limite)
      return true;
    return false;
  }

  public float pedaggio(Auto v){
    if(v.potenza < this.potenzaMinimaPerAccedere)
      return -1;
    if(v.assi <= 3)
      return this.tariffaBase*this.lunghezza;
    return this.tariffaBase*this.lunghezza*1.5f;
  }

  public Biglietto ingresso(Auto v){
    if(v.potenza < potenzaMinimaPerAccedere)
      return null;
    Biglietto b = new Biglietto();
    arr.add(v, b);
    return b;
  }

  public float uscita(Auto v){
    if(!(arr.containsKey(v))){ //containsKey per vedere se ha l'indice v
      return -1;
    }
    Biglietto b = arr.get(v);
    arr.remove(v);
    float p = pedaggio(v);
    if(superatoLimite((System.currentTimeMillis()-b.timestamp)/1000))
      p += 100;
    return p;
  }


}
