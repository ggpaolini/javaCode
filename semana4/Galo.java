import java.util.Scanner;

public class Galo {
   int n;
   char[][] tab;

   Galo(int n) {
      this.n = n;
      tab = new char[n][n];
   }

   public void read(Scanner sc) {
      for (int i = 0; i < n; i++) {
         String str = sc.next();
         for (int j = 0; j < n; j++) {
            tab[i][j] = str.charAt(j);
         }
      }
   }

   public boolean finished() {
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (tab[i][j] == '.')
               return false;
         }
      }
      return true;
   }

   public void check() {
      for (int k = 0; k < n; k++) {
         verify(k, 0, 0, 1);
         verify(0, k, 1, 0);
      }
      verify(0, 0, 1, 1);
      verify(0, n - 1, 1, -1);
      if (!finished())
         System.out.println("Jogo incompleto");
      else
         System.out.println("Empate");
   }

   public void verify(int i, int j, int incI, int incJ) {
      if (tab[i][j] == '.')
         return;
      int newI = i, newJ = j;
      for (int k = 0; k < n; k++) {
         if (tab[newI][newJ] != tab[i][j])
            return;
         newI += incI;
         newJ += incJ;
      }

      win(tab[i][j]);
   }

   public void win(char player) {
      System.out.println("Ganhou o " + player);
      System.exit(0);
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Galo galo = new Galo(n);
      galo.read(sc);
      galo.check();
   }
}
