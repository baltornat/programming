import java.util.*;

/** Le istanze di questa classe sono pacchetti Amazon
@author Marco Cesana */

public class Pacchetto{
  private double x,y,z;
  private double g;

  /** Costruisce un pacchetto date le 3 dimensioni x,y,z e il peso.
      i parametri x,y,z espressi in cm, il peso espresso in grammi.
    @param x: la larghezza
    @param y: la lunghezza
    @param z: la profondità
    @param g: il peso */
  public Pacchetto(double x, double y, double z, double g){
    this.x=x;
    this.y=y;
    this.z=z;
    this.g=g;
  }

  /** Calcola il volume dell'oggetto su cui è invocato.
    @return il volume */
  public double volume(){
    return (x*y*z);
  }

  /** Calcola la somma delle aree dell'oggetto su cui è invocato.
    @return la somma */
  public double superficie(){
    return(2*(x*y)+2*(x*z)+2*(y*z));
  }

  /** Verifica se il pacchetto su cui è invocato galleggia oppure no.
    @return true: se peso/volume < 1.0
    @return false: se volume == 0 || peso/volume >= 1.0 */
  public boolean galleggia(){
    double volume=volume();
    if(volume!=0){
      double pesoSpecifico = g / volume();
      return pesoSpecifico < 1.0;
    }else{
      return false;
    }
  }

  public double getX(){
      return this.x;
  }

  public double getY(){
      return this.y;
  }

  public double getZ(){
      return this.z;
  }

  public double getG(){
      return this.g;
  }

  @Override
  public String toString(){
    return "Scatola "+ x +"*"+ y +"*"+ z +" con peso pari a: "+ g +" grammi.";
  }

  @Override
  public boolean equals(Object altro){
    if(!(altro instanceof Pacchetto)){
      return false;
    }
    Pacchetto o=(Pacchetto) altro;
    return o.x==x && o.y==y && o.z==z && o.g==g;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    System.out.print("Inserisci la larghezza: ");
    double x=in.nextDouble();
    System.out.print("Inserisci la lunghezza: ");
    double y=in.nextDouble();
    System.out.print("Inserisci la profondità: ");
    double z=in.nextDouble();
    System.out.print("Inserisci il peso: ");
    double g=in.nextDouble();
    Pacchetto uno=new Pacchetto(x,y,z,g);
    System.out.println(uno.toString());
    System.out.println("Il volume del pacchetto è: "+uno.volume()+" cm cubi");
    if(uno.galleggia()){
      System.out.println("Il pacchetto galleggia!");
    }else{
      System.out.println("Il pacchetto non galleggia!");
    }
  }
}
