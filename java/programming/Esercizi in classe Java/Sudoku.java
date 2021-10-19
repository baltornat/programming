import java.util.*;

public class Sudoku{
  private int[][] cella; //0=vuota oppure 1-9
  private boolean frozen;
  private boolean[][] bloccata;

  public Sudoku(){
    cella=new int[9][9];
    bloccata=new boolean[9][9];
  }

  public void riempi(int riga, int colonna, int valore){
    if(riga<0 || riga>8 || colonna<0 || colonna>8 || valore<1 || valore>9)
      throw new IllegalArgumentException();
    if(frozen && bloccata[riga][colonna])
      throw new IllegalStateException();
    cella[riga][colonna]=v;
    if(!frozen)
      bloccata[riga][colonna]=true;
  }

  public void freeze(){
    frozen=true;
  }

  public boolean finito(){
    int riga, colonna;

    for(riga=0; riga<9; riga++)
      for(colonna=0; colonna<10; colonna++)
        if(cella[riga][colonna]==0)
          return false;
    for(riga=0; riga<9; riga++)
      if(ripetizioniSuRiga(riga))
        return false;
  }

  private boolean ripetizioniSuRiga(int r){
    HashSet<Integer> values=new HashSet<>();
    for(int c=0; c<9; c++)
      values.add(cella[r][c]);
    return values.size()<9;
  }

  public boolean ripetizioniInQuadrato(int rr, int cc){
    HashSet<Integer> values=new HashSet<>();
    int nonZero=0;
    for(int r=0; r<3; r++)
      for(int c=0; c<3; c++){
        int v=cella[3*rr+r][3*cc+c];
        if(v!=0){
          values.add(v);
          nonZero++;
        }
      }
    return (values.size()<nonZero);
  }

}
