import java.util.Scanner;

public class ED029 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int c = sc.nextInt();
      sc.nextLine();

      for (int i = 0; i < c; i++) {
         int l = sc.nextInt();
         int a = sc.nextInt();

         LinkedListQueue<String> levanta = new LinkedListQueue<>();
         LinkedListQueue<String> aterra = new LinkedListQueue<>();

         LinkedListQueue<Integer> lTempo = new LinkedListQueue<>();
         LinkedListQueue<Integer> aTempo = new LinkedListQueue<>();

         for (int j = 0; j < l; j++) {
            levanta.enqueue(sc.next());
            lTempo.enqueue(sc.nextInt());
         }

         for (int j = 0; j < a; j++) {
            aterra.enqueue(sc.next());
            aTempo.enqueue(sc.nextInt());
         }
         // inicio algoritmo----------------------------------------------------------
         MyQueue<Integer> lAtraso = new LinkedListQueue<>();
         MyQueue<Integer> aAtraso = new LinkedListQueue<>();

         int j = 0;
         while (aTempo.size() != 0 || lTempo.size() != 0) {
            // se a primeira parte do ou for v, ja nao se avalia a 2a
            if ((aTempo.size() == 0 || j < aTempo.first()) && (lTempo.size() == 0 || j < lTempo.first())) {
               j++;
               continue;
            }
            if (aTempo.size() != 0 && lTempo.size() != 0) {
               if (aTempo.first() <= lTempo.first()) {
                  int tempo = aTempo.dequeue() - j;
                  if (tempo > 0)
                     tempo = 0;
                  aAtraso.enqueue(Math.abs(tempo));
               } else {
                  int tempo = lTempo.dequeue() - j;
                  if (tempo > 0)
                     tempo = 0;
                  lAtraso.enqueue(Math.abs(tempo));
               }
            } else if (aTempo.size() != 0) {
               int tempo = aTempo.dequeue() - j;
               if (tempo > 0)
                  tempo = 0;
               aAtraso.enqueue(Math.abs(tempo));
            } else if (lTempo.size() != 0) {
               int tempo = lTempo.dequeue() - j;
               if (tempo > 0)
                  tempo = 0;
               lAtraso.enqueue(Math.abs(tempo));
            }
            j++;
         }
         // fim algoritmo----------------------------------------------------------------
         System.out.println(l + " " + a);

         for (int k = 0; k < l; k++) {
            String aviao = levanta.dequeue();
            int min = lAtraso.dequeue();
            System.out.println(aviao + " " + min);
         }

         for (int k = 0; k < a; k++) {
            String aviao = aterra.dequeue();
            int min = aAtraso.dequeue();
            System.out.println(aviao + " " + min);
         }

      }
   }
}
