import java.util.Scanner;

public class ED237 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int n = sc.nextInt();
      MyQueue<Processo> processos = new LinkedListQueue<>();
      for (int i = 0; i < n; i++) {
         String nome = sc.next();
         int tempo = sc.nextInt();
         Processo p = new Processo(nome, tempo);
         processos.enqueue(p);
      }
      int iters = 0, tempo = 0;
      while (processos.size() != 0) {
         iters++;
         Processo p = processos.dequeue();
         for (int i = 0; i < t; i++) {
            p.time--;
            tempo++;
            if (p.time == 0) {
               System.out.println(p.name + " " + tempo + " " + iters);
               break;
            }
         }
         if (p.time > 0)
            processos.enqueue(p);
         // System.out.println(iters + " " + tempo);
      }
   }
}

class Processo {
   String name;
   int time;

   public Processo(String nome, int tempo) {
      name = nome;
      time = tempo;
   }
}
