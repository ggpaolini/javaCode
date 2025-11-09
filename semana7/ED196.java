public class ED196 {
   public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
      int len = q.size();
      for (int i = 0; i < len / 2; i++) {
         // System.out.println(i);
         String nome = q.dequeue();
         String next = q.dequeue();
         if (next.equals("A"))
            a.enqueue(nome);
         else if (next.equals("B"))
            b.enqueue(nome);
         else {
            if (a.size() > b.size())
               b.enqueue(nome);
            else if (b.size() > a.size())
               a.enqueue(nome);
            else
               continue;
         }
      }
   }

   public static void main(String[] args) {
      MyQueue<String> q = new LinkedListQueue<>();
      MyQueue<String> a = new LinkedListQueue<>();
      MyQueue<String> b = new LinkedListQueue<>();
      q.enqueue("Luis");
      q.enqueue("B");
      q.enqueue("Pedro");
      q.enqueue("A");
      q.enqueue("Luisa");
      q.enqueue("A");
      q.enqueue("Joao");
      q.enqueue("X");
      q.enqueue("Jose");
      q.enqueue("X");
      q.enqueue("Miguel");
      q.enqueue("B");
      process(q, a, b);
      System.out.println(q);
      System.out.println(a);
      System.out.println(b);
   }
}
