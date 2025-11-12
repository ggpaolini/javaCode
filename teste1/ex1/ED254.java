import java.util.Scanner;

public class ED254 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for (int c = 0; c < n; c++) {
         int size = sc.nextInt();
         for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
               if (j == i || j == size - 1 - i)
                  System.out.print("#");
               else
                  System.out.print(".");
            }
            System.out.println();
         }
         for (int i = 0; i < size / 2 + 1; i++) {
            for (int j = 0; j < size; j++) {
               if (j == size / 2)
                  System.out.print("#");
               else
                  System.out.print(".");
            }
            System.out.println();
         }
      }
   }
}
