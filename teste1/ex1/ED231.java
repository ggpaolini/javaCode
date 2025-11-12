import java.util.Scanner;

public class ED231 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }
      int flag = sc.nextInt();

      if (flag == 1) {
         int min = arr[1] - arr[0];
         int max = arr[1] - arr[0];
         for (int i = 2; i < n; i++) {
            int dif = arr[i] - arr[i - 1];
            if (dif < min)
               min = dif;
            else if (dif > max)
               max = dif;
         }
         System.out.println(min + " " + max);

      } else if (flag == 2) {
         int count = 0;
         int max = 0;
         int tmp = 0;
         for (int i = 1; i < n; i++) {
            double taxa = ((double) (arr[i] - arr[i - 1]) / arr[i - 1]) * 100;
            if (taxa <= 5) {
               tmp++;
            } else {
               if (tmp > max) {
                  max = tmp;
               }
               if (tmp > 0)
                  count++;
               tmp = 0;
            }
         }
         if (tmp > 0)
            count++;
         if (tmp > max)
            max = tmp;
         System.out.println(count + " " + max);
      } else {
         int[] heights = new int[n];
         int max = 0;
         for (int i = 0; i < n; i++) {
            int height = arr[i] / 100;
            heights[i] = height;
            if (height > max)
               max = height;
         }
         for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
               if (heights[j] > i)
                  System.out.print("#");
               else
                  System.out.print(".");
            }
            System.out.println();
         }
      }
   }
}
