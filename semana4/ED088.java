import java.util.Scanner;

class Game {
   private int rows;
   private int cols;
   private char[][] tab;

   Game(int rows, int cols) {
      this.rows = rows;
      this.cols = cols;
      tab = new char[rows][cols];
   }

   public void read(Scanner sc) {
      for (int i = 0; i < rows; i++) {
         String str = sc.next();
         for (int j = 0; j < cols; j++) {
            tab[i][j] = str.charAt(j);
         }
      }
   }

   public void write() {
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            System.out.print(tab[i][j]);
         }
         System.out.println();
      }
   }

   public int countAlive(int i, int j) {
      int count = 0;
      for (int di = -1; di <= 1; di++) {
         for (int dj = -1; dj <= 1; dj++) {
            if (di == 0 && dj == 0)
               continue;
            int newi = i + di;
            int newj = j + dj;
            if (newi >= 0 && newj >= 0 && newi <= rows - 1 && newj <= cols - 1) {
               if (tab[newi][newj] == 'O')
                  count++;
            }
         }
      }
      return count;
   }

   public void iterate() {
      char[][] newTab = new char[rows][cols];
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            int neighbours = countAlive(i, j);
            if (tab[i][j] == 'O') {
               if (neighbours <= 1 || neighbours >= 4)
                  newTab[i][j] = '.';
               else
                  newTab[i][j] = 'O';
            } else {
               if (neighbours == 3)
                  newTab[i][j] = 'O';
               else
                  newTab[i][j] = '.';
            }
         }
      }
      tab = newTab;
   }
}

public class ED088 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int l = sc.nextInt();
      int c = sc.nextInt();
      int iters = sc.nextInt();
      Game g = new Game(l, c);
      g.read(sc);
      for (int i = 0; i < iters; i++) {
         g.iterate();
      }
      g.write();
   }
}
