import java.util.Scanner;
import java.util.Random;

public class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   public Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }
   public Matrix(int r, int c, int min, int max){
      data = new int[r][c];
      rows = r;
      cols = c;
      Random rand = new Random();
      for (int i = 0; i < r; i++){
        for (int j = 0; j < c; j++){
            data[i][j] = rand.nextInt(max - min + 1) +min;
        }
      }
   }

   public static Matrix identity(int n){
    Matrix m = new Matrix(n, n);
    for (int i = 0; i< n; i++){
        for (int j = 0; j< n; j++){
            if (i == j) m.data[i][j] = 1;
            else m.data[i][j] = 0;
        }
    }
    return m;
   }
   public Matrix transpose(){
    Matrix newM = new Matrix(this.cols, this.rows);
    for (int i = 0; i < newM.rows; i++){
        for (int j = 0; j< newM.cols; j++){
            newM.data[i][j] = this.data[j][i];
        }
    }
    return newM;
   }

   public Matrix sum(Matrix m){
    Matrix newM = new Matrix(this.rows, this.cols);
    for (int i = 0; i < this.rows; i++){
        for (int j = 0; j< this.cols; j++){
            newM.data[i][j] = this.data[i][j] + m.data[i][j];
        }
    }
    return newM;
   }

   public Matrix multiply(Matrix m){
    Matrix newM = new Matrix(this.rows, m.cols);
    for (int i = 0; i < newM.rows; i++){
        for (int j = 0; j< newM.cols; j++){
            for (int k = 0; k < this.cols; k++){
                newM.data[i][j] += (this.data[i][k] * m.data[k][j]);
                //System.out.print( newM.data[i][j] +" ");
            } 
        }
    }
    return newM;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matriz
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }   
}
