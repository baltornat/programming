import java.util.*;

public class CampoMinato{
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    Scanner in = new Scanner(System.in);
    ArrayList<String> arr = new ArrayList<>();
    char[][] matrix = new char[n][n];
    int cont=1;
    while(cont<=n){
      String s = in.next();
      arr.add(s);
      cont++;
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        matrix[i][j]=arr.get(i).charAt(j);
      }
    }

  }

  public static int asteriscoInRigaColonna(char matrix[][], int i, int j){
    int numeroRighe = matrix.length;
    int numeroColonne = matrix[0].length;
    if(i<numeroRighe && j<numeroColonne && matrix[i][j]=='*')
      return 1;
    return 0;
  }

  public static int cellaValida(char matrix[][], int i, int j){
    int numeroRighe = matrix.length;
    int numeroColonne = matrix[0].length;
    if(i<numeroRighe)
      return -1;
    if(j<numeroColonne)
      return -2;
    return 0;
  }

  public static int nMineAdiacenti(char matrix[][], int r, int c){
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        if(cellaValida(matrix[][],i,j-1)==0){
          
        }
      }
    }
  }
}
