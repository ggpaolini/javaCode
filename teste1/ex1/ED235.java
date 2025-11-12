import java.util.Scanner;

public class ED235 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for (int c = 0; c < n; c++) {
         int size = sc.nextInt();
         for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
               if (j < size - i)
                  System.out.print("#");
               else
                  System.out.print(".");
            }
            System.out.println();
         }
      }
   }
}
