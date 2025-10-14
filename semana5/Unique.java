import java.util.Scanner;

public class Unique {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      IntSet s = new ArrayListIntSet(Integer.parseInt(args[0]));
      while (sc.hasNextInt()) {
         s.add(sc.nextInt());
      }
      System.out.println(s.size());
   }
}
