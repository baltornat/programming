import java.util.*;

public class StazioneMeteo{
  private int[] temperatura = new int[32];
  private int[] precipitazione = new int[32];
  private int giornoCorrente;

  public void setGiorno(int g){
    this.giornoCorrente=g;
  }

  public void setTemperatura(int t){
    this.temperatura[this.giornoCorrente]=t;
  }

  public void setPrecipitazioni(int p){
    this.precipitazione[this.giornoCorrente]=p;
  }

  public int getGiorno(){
    return this.giornoCorrente;
  }

  public int getTemperatura(){
    return this.temperatura[this.giornoCorrente];
  }

  public int getPrecipitazioni(){
    return this.precipitazione[this.giornoCorrente];
  }

  public int maxTemperatura(int g){
    int max = Integer.MIN_VALUE;
    for(int i=0; i<g; i++){
      if(this.temperatura[i]>max){
        max = this.temperatura[i];
      }
    }
    return max;
  }

  public double mediaTemperature(int g){
    int somma = 0;
    int totale
    for(int i=0; i<g; i++){
      somma+=temperatura[i];
    }
    return (double)(somma/g);
  }

  public int totPrecipitazioni(int g){
    int somma = 0;
    for(int i=0; i<g; i++){
      somma+=precipitazione[i];
    }
    return somma;
  }
}
