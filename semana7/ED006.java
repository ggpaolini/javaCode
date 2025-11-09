import java.util.Scanner;

public class ED006 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      sc.nextLine();

      for (int c = 0; c < n; c++) {
         String frase = sc.nextLine();
         String[] arr = frase.split(" ");

         int k = sc.nextInt();
         CircularLinkedList<String> criancas = new CircularLinkedList<>();
         for (int i = 0; i < k; i++) {
            criancas.addLast(sc.next());
         }
         while (criancas.size() > 1) {
            for (int i = 1; i < arr.length; i++) {
               criancas.rotate();
            }
            criancas.removeFirst();
         }
         if (c != n - 1)
            sc.nextLine();

         String lixouse = criancas.getFirst();
         if (lixouse.equals("Carlos"))
            System.out.println("O Carlos nao se livrou");
         else
            System.out.println("O Carlos livrou-se (coitado do " + lixouse + "!)");
      }
   }
}
