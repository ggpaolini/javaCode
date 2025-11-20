import java.util.Scanner;

public class ED201 {

   public static int bestSubSet(int cur, int[] arr, boolean[] used, int d, int bestTime) {
      if (cur == arr.length) {
         int time = 0;
         for (int i = 0; i < arr.length; i++) {
            if (used[i])
               time += arr[i];
         }
         if (time <= d && time > bestTime)
            return time;
         return bestTime;
      }

      used[cur] = true;
      int best1 = bestSubSet(cur + 1, arr, used, d, bestTime);
      used[cur] = false;
      int best2 = bestSubSet(cur + 1, arr, used, d, bestTime);
      return Math.max(best1, best2);
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int d = sc.nextInt();
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }
      boolean[] used = new boolean[n];
      int bestTime = 0;
      System.out.println(bestSubSet(0, arr, used, d, bestTime));
   }
}
