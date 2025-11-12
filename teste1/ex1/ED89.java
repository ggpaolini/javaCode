import java.util.Scanner;

public class ED89 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int flag = sc.nextInt();
      int[] areas = new int[100];
      for (int i = 0; i < n; i++) {
         sc.next();
         sc.nextLine();
         sc.nextLine();
         sc.next();
         int area = sc.nextInt();
         areas[area - 1] += sc.nextInt();
      }
      if (flag == 1) {
         for (int i = 0; i < 100; i++) {
            if (areas[i] != 0) {
               System.out.println(i + 1 + " " + areas[i]);
            }
         }
      } else {
         int count = 0;
         for (int i = 0; i < 100; i++) {
            if (areas[i] != 0)
               count++;
         }
         System.out.println(count);
      }
   }
}
