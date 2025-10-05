import java.util.Scanner;

public class Npoint {
   int cords[];
   int n;

   public Npoint(int n, Scanner sc) {
      cords = new int[n];
      this.n = n;
      for (int i = 0; i < n; i++) {
         cords[i] = sc.nextInt();
      }
   }

   public void toString1(){
      System.out.print("(");
      for (int i = 0; i < this.n; i++){
         if (i == n-1) System.out.println(cords[i] + ")");
         else System.out.print(cords[i] + ", ");
      }
   }
}
