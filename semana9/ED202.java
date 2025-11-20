import java.util.Scanner;

public class ED202 {

   public static double perm(int cur, double[][] distances, int[] perm, boolean[] used, double bestDistance) {
      int n = distances.length;
      if (cur == n - 1) {
         double total = 0;
         total += distances[0][perm[0]];
         for (int i = 0; i < n - 2; i++)
            total += distances[perm[i]][perm[i + 1]];
         total += distances[perm[n - 2]][0];
         if (total < bestDistance)
            return total;
         return bestDistance;
      }

      for (int i = 1; i < n; i++) {
         if (!used[i]) {
            used[i] = true;
            perm[cur] = i;
            double r = perm(cur + 1, distances, perm, used, bestDistance);
            if (r < bestDistance)
               bestDistance = r;
            used[i] = false;
         }
      }
      return bestDistance;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      String[] arr = new String[n];
      for (int i = 0; i < n; i++) {
         arr[i] = sc.next();
      }
      double[][] distances = new double[n][n];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            distances[i][j] = sc.nextDouble();
         }
      }

      int[] perm = new int[n - 1];
      boolean[] used = new boolean[n];
      Double bestDistance = Double.MAX_VALUE;

      System.out.printf("%.2f%n", perm(0, distances, perm, used, bestDistance));

   }
}
