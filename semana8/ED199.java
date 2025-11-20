import java.util.Scanner;

public class ED199 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int b = sc.nextInt();
      int I = sc.nextInt();
      char[] tesouros = sc.next().toCharArray();

      // mais eficiente
      b--;
      int count = 0;
      int maxD = b;
      int minE = b;
      for (int i = 0; i < I; i++) {
         char dir = sc.next().charAt(0);
         int passos = sc.nextInt();
         if (dir == 'D') {
            b += passos;
            if (b > maxD)
               maxD = b;
         } else {
            b -= passos;
            if (b < minE)
               minE = b;
         }
      }
      for (int i = minE; i <= maxD; i++) {
         if (tesouros[i] == 'T')
            count++;
      }

      /*
       * boolean[] visited = new boolean[n];
       * b--;
       * int count = 0;
       * 
       * visited[b] = true;
       * if (tesouros[b] == 'T')
       * count++;
       * 
       * for (int i = 0; i < I; i++) {
       * char dir = sc.next().charAt(0);
       * int passos = sc.nextInt();
       * 
       * if (dir == 'D') {
       * for (int j = 1; j <= passos; j++) {
       * if (!visited[b + j]) {
       * visited[b + j] = true;
       * if (tesouros[b + j] == 'T')
       * count++;
       * }
       * }
       * b += passos;
       * 
       * } else {
       * for (int j = 1; j <= passos; j++) {
       * if (!visited[b - j]) {
       * visited[b - j] = true;
       * if (tesouros[b - j] == 'T')
       * count++;
       * }
       * }
       * b -= passos;
       * }
       * }
       */

      System.out.println(count);
   }
}
