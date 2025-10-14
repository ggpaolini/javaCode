import java.util.Scanner;

class SopaDeLetras {
   private int lines;
   private int cols;
   private char[][] letras;
   private String[] words;
   private int[][] isWord;

   SopaDeLetras(int lines, int cols) {
      this.lines = lines;
      this.cols = cols;
      letras = new char[lines][cols];
      isWord = new int[lines][cols];
   }

   public void readSopa(Scanner sc) {
      for (int i = 0; i < lines; i++) {
         String str = sc.next();
         for (int j = 0; j < cols; j++) {
            letras[i][j] = str.charAt(j);
         }
      }
   }

   public void readWords(int n, Scanner sc) {
      words = new String[n];
      for (int i = 0; i < n; i++) {
         words[i] = sc.next();
      }
   }

   public void solve() {
      int n = words.length;
      String word;
      for (int i = 0; i < n; i++) {
         word = words[i];
         check(word);
      }
   }

   public void check(String word) {
      for (int i = 0; i < lines; i++) {
         for (int j = 0; j < cols; j++) {
            checkWord(word, i, j, 0, 1);
            checkWord(word, i, j, 1, 0);
            checkWord(word, i, j, 0, -1);
            checkWord(word, i, j, -1, 0);
         }
      }
   }

   public void checkWord(String word, int i, int j, int diri, int dirj) {
      int n = word.length();
      int newI = i, newJ = j;
      for (int k = 0; k < n; k++) {
         if ((newI < 0) || (newI >= lines) || (newJ < 0) || (newJ >= cols) || (letras[newI][newJ] != word.charAt(k)))
            return;
         newI += diri;
         newJ += dirj;
      }
      markWord(n, i, j, diri, dirj);
   }

   public void markWord(int n, int i, int j, int diri, int dirj) {
      int newI = i, newJ = j;
      for (int k = 0; k < n; k++) {
         isWord[newI][newJ] = 1;
         newI += diri;
         newJ += dirj;
      }
   }

   public void write() {
      for (int i = 0; i < lines; i++) {
         for (int j = 0; j < cols; j++) {
            if (isWord[i][j] == 0)
               System.out.print('.');
            else
               System.out.print(letras[i][j]);
         }
         System.out.println();
      }
   }
}

public class ED015 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int l, c, input = 1;
      while ((l = sc.nextInt()) != 0 && (c = sc.nextInt()) != 0) {
         SopaDeLetras sopa = new SopaDeLetras(l, c);
         sopa.readSopa(sc);
         int n = sc.nextInt();
         sopa.readWords(n, sc);
         sopa.solve();
         System.out.println("Input #" + input++);
         sopa.write();
      }
   }
}
