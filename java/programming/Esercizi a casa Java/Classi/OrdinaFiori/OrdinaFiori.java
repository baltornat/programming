import java.util.*;

/** Questa classe consente ad un utente di creare un mazzo di fiori
    e di visualizzarne il contenuto ed il prezzo
    @author Marco Cesana */
public class OrdinaFiori{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String nome="";
    int prezzo, quantita;

    Mazzo m=new Mazzo();

    /** Creo degli oggetti "Fiore" predefiniti */
    Fiore f1=new Fiore("rosa",10.0);
    Fiore f2=new Fiore("margherita",3.0);
    Fiore f3=new Fiore("tulipano",1.5);
    Fiore f4=new Fiore("viola",0.75);
    Fiore f5=new Fiore("orchidea",7.30);

    /**Esco dal ciclo quando inserisco "stop" */
    while(true){
      System.out.print("Inserisci il nome di un fiore da aggiungere al mazzo: ");
      nome=in.nextLine().trim();
      if(nome.equals("stop"))
        break;
      System.out.print("Inserisci la quantità di "+nome+" che desideri: ");
      quantita=in.nextInt();
      in.nextLine();
      switch(nome){
        case "rosa": m.add(f1,quantita);
          break;
        case "margherita": m.add(f2,quantita);
          break;
        case "tulipano": m.add(f3,quantita);
          break;
        case "viola": m.add(f4,quantita);
          break;
        case "orchidea": m.add(f5,quantita);
          break;
        default: System.out.println("Errore fatale!");
      }
    }

    /** Eseguo la stampa del mazzo utilizzando il metodo toString
        che ho sovrascritto nella classe "Mazzo" */
    System.out.println(m.toString());
  }
}
