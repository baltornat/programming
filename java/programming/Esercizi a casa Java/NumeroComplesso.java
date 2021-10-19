import java.util.*;

public class NumeroComplesso{
  private double a;
  private double b;

  public NumeroComplesso(double a, double b){
    this.a=a;
    this.b=b;
  }

  public NumeroComplesso(double a){
    this.a=a;
    this.b=0;
  }

  public NumeroComplesso piu(NumeroComplesso compl){
    NumeroComplesso somma=new NumeroComplesso(this.a+compl.a, this.b+compl.b);
    return somma;
  }

  public NumeroComplesso per(NumeroComplesso compl){
    NumeroComplesso prodotto=new NumeroComplesso((this.a*compl.a)-(this.b*compl.b), ((this.a*compl.b)+(this.b*compl.a)));
    return prodotto;
  }

  @Override
  public String toString(){
      return this.a+" + i"+this.b;
  }


  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    System.out.print("Inserisci la parte reale: ");
    double r=in.nextDouble();
    System.out.print("Inserisci la parte immaginaria: ");
    double i=in.nextDouble();
    NumeroComplesso n=new NumeroComplesso(r,i);
    System.out.println("Numero inserito: "+n.toString());

    System.out.print("Inserisci la parte reale: ");
    double r2=in.nextDouble();
    System.out.print("Inserisci la parte immaginaria: ");
    double i2=in.nextDouble();
    NumeroComplesso n2=new NumeroComplesso(r2,i2);
    System.out.println("Numero inserito: "+n2.toString());

    System.out.println();
    NumeroComplesso somma=n.piu(n2);
    System.out.println("Somma: "+somma.toString());

    System.out.println();
    NumeroComplesso prodotto=n.per(n2);
    System.out.println("Prodotto: "+prodotto.toString());
  }
}
