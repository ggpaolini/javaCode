import java.util.Scanner;

public class ED198 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];
      int[] best = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }
      // algoritmo de kodane: o(n)
      best[0] = arr[0];
      int max = best[0];
      for (int i = 0; i < n - 1; i++) {
         if (best[i] > 0) {
            best[i + 1] = best[i] + arr[i + 1];
         } else {
            best[i + 1] = arr[i + 1];
         }
         if (best[i] > max)
            max = best[i];
      }
      if (best[n - 1] > max)
         max = best[n - 1];
      /*
       * quadratic
       * int max = arr[0];
       * for (int size = 1; size <= n; size++) {
       * int sum = 0;
       * for (int j = 0; j < size; j++) {
       * sum += arr[j];
       * }
       * if (sum > max)
       * max = sum;
       * for (int i = 1; i < n - size; i++) {
       * sum = sum - arr[i - 1] + arr[i + size - 1];
       * if (sum > max)
       * max = sum;
       * }
       * }
       */
      System.out.println(max);
   }
}
