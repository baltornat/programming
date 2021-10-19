import java.util.*;
import java.io.*;

public class CalcoloCodiceFiscale{
  public static String cognome(String s){
    StringBuilder sb = new StringBuilder();
    ArrayList<Character> vocali = new ArrayList<>();
    ArrayList<Character> consonanti = new ArrayList<>();
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
        vocali.add(c);
      else
        consonanti.add(c);
    }
    if(s.length()==2 && consonanti.size()==1){
      sb.append(consonanti.get(0));
      sb.append(vocali.get(0));
      return sb.toString()+"X";
    }else{
      if(s.length()==2 && consonanti.size()<1){
        return s+"X";
      }
    }
    if(consonanti.size()>=3){
      sb.append(consonanti.get(0));
      sb.append(consonanti.get(1));
      sb.append(consonanti.get(2));
    }else{
      int cont=0;
      for(int i=0; i<consonanti.size(); i++){
        sb.append(consonanti.get(i));
        cont++;
      }
      for(int i=0; i<3-cont; i++){
        sb.append(vocali.get(i));
      }
    }
    return sb.toString();
  }

  public static String nome(String s){
    StringBuilder sb = new StringBuilder();
    ArrayList<Character> vocali = new ArrayList<>();
    ArrayList<Character> consonanti = new ArrayList<>();
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
        vocali.add(c);
      else
        consonanti.add(c);
    }
    if(s.length()==2 && consonanti.size()==1){
      sb.append(consonanti.get(0));
      sb.append(vocali.get(0));
      return sb.toString()+"X";
    }else{
      if(s.length()==2 && consonanti.size()<1){
        return s+"X";
      }
    }
    if(consonanti.size()>=4){
      sb.append(consonanti.get(0));
      sb.append(consonanti.get(2));
      sb.append(consonanti.get(3));
    }else{
      if(consonanti.size()==3){
        sb.append(consonanti.get(0));
        sb.append(consonanti.get(1));
        sb.append(consonanti.get(2));
      }else{
        int cont=0;
        for(int i=0; i<consonanti.size(); i++){
          sb.append(consonanti.get(i));
          cont++;
        }
        for(int i=0; i<3-cont; i++){
          sb.append(vocali.get(i));
        }
      }
    }
    return sb.toString();
  }

  public static String annoNascita(String s){
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(2));
    sb.append(s.charAt(3));
    return sb.toString();
  }

  public static String meseNascita(String s){
    StringBuilder sb = new StringBuilder();
    switch(s){
      case "GENNAIO": sb.append('A');
        break;
      case "FEBBRAIO": sb.append('B');
        break;
      case "MARZO": sb.append('C');
        break;
      case "APRILE": sb.append('D');
        break;
      case "MAGGIO": sb.append('E');
        break;
      case "GIUGNO": sb.append('H');
        break;
      case "LUGLIO": sb.append('L');
        break;
      case "AGOSTO": sb.append('M');
        break;
      case "SETTEMBRE": sb.append('P');
        break;
      case "OTTOBRE": sb.append('R');
        break;
      case "NOVEMBRE": sb.append('S');
        break;
      case "DICEMBRE": sb.append('T');
        break;
    }
    return sb.toString();
  }

  public static String giornoNascitaSesso(String s, String sesso){
    StringBuilder sb = new StringBuilder();
    int gNascita = Integer.parseInt(s);
    if(gNascita<10 && sesso.equals("M")){
      sb.append('0');
      sb.append(gNascita);
    }else{
      if(sesso.equals("F")){
        sb.append(gNascita+40);
      }else{
        sb.append(gNascita);
      }
    }
    return sb.toString();
  }

  public static String codice(String s, String c)throws FileNotFoundException{
    FileInputStream file = new FileInputStream(c);
    Scanner in = new Scanner(file);
    String pre = "";
    while(in.hasNextLine()){
      String s1 = in.nextLine();
      int index = s1.indexOf(s);
      pre = s1.substring(0, 5);
      if(index!=-1){
        break;
      }
    }
    return pre;
  }

  public static String comune(String s)throws FileNotFoundException{
    String primaLettera = s.substring(0,1);
    String s1 = codice(s,"Comuni/"+primaLettera);
    return s1;
  }

  public static int somma(ArrayList<String> arr, String c)throws FileNotFoundException{
    int somma = 0;
    for(int i=0; i<arr.size(); i++){
      FileInputStream file = new FileInputStream(c);
      Scanner in = new Scanner(file);
      while(in.hasNext()){
        String prima = in.next();
        String seconda = in.next();
        if(prima.equals(arr.get(i))){
          somma = somma + Integer.parseInt(seconda);
        }
      }
    }
    return somma;
  }

  public static String resto(int sommaTot)throws FileNotFoundException{
    int resto = sommaTot%26;
    FileInputStream file = new FileInputStream("Tabelle/Resto");
    Scanner in = new Scanner(file);
    String s = Integer.toString(resto);
    String text = "";
    while(in.hasNext()){
      text = in.next();
      if(s.equals(text.substring(1))){
        break;
      }
    }
    return text.substring(0,1);
  }

  public static String CIN(String s)throws FileNotFoundException{
    s.trim();
    ArrayList<String> dispari = new ArrayList<>();
    ArrayList<String> pari = new ArrayList<>();
    for(int i=1; i<s.length(); i++){
      char temp = s.charAt(i-1);
      String temp1 = Character.toString(temp);
      if(i%2!=0){
        dispari.add(temp1);
      }else{
        pari.add(temp1);
      }
    }
    int sommaTot = somma(dispari, "Tabelle/Dispari")+somma(pari, "Tabelle/Pari");
    s=s.trim()+(resto(sommaTot)).trim();
    return s;
  }

  public static void main(String[] args)throws FileNotFoundException{
    Scanner in = new Scanner(System.in);
    int cont = 0;
    StringBuilder sb = new StringBuilder();
    System.out.println("Formato di inserimento dei dati: (Se possiedi un secondo nome scrivilo unito al primo: MATTEOSIMONE per esempio)");
    System.out.println("COGNOME NOME ANNO MESE GIORNO SESSO COMUNE");

    String cognome = in.next().toUpperCase();
    String nome = in.next().toUpperCase();
    String anno = in.next();
    String mese = in.next().toUpperCase();
    String giorno = in.next();
    String sesso = in.next().toUpperCase();
    String comune = in.next().toUpperCase();
    sb.append(cognome(cognome));
    sb.append(nome(nome));
    sb.append(annoNascita(anno));
    sb.append(meseNascita(mese));
    sb.append(giornoNascitaSesso(giorno, sesso));
    sb.append(comune(comune));
    String s = sb.toString();
    String codiceFiscale = CIN(s);
    System.out.println(codiceFiscale);
  }
}
