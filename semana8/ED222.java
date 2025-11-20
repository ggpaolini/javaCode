import java.util.Scanner;

public class ED222 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      int t = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
         arr[i] = sc.nextInt();

      // mais eficiente
      int k1 = k;
      if (k % 2 == 1) {
         k1 = k + 1;
      }
      int count = 0;
      int q = 0;
      for (int j = 0; j < k; j++) {
         if (arr[j] >= t)
            q++;
      }
      if (q >= k1 / 2)
         count++;
      for (int i = 0; i < n - k; i++) {
         int last = arr[i + k];
         if (arr[i] >= t)
            q--;
         if (last >= t)
            q++;
         if (q >= k1 / 2)
            count++;
      }
      /*
       * int k1 = k;
       * if (k % 2 == 1) {
       * k1 = k + 1;
       * }
       * int count = 0;
       * for (int i = 0; i < n - k + 1; i++) {
       * int tmpCount = 0;
       * boolean dont = false;
       * for (int j = 0; j < k; j++) {
       * if (tmpCount >= k1 / 2) {
       * dont = true;
       * count++;
       * break;
       * }
       * if (arr[i + j] >= t)
       * tmpCount++;
       * }
       * if (!dont && tmpCount >= k1 / 2) {
       * count++;
       * }
       * }
       */
      System.out.println(count);

   }
}
