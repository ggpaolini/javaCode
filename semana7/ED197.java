public class ED197 {
   public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
      MyQueue<Integer> newQ = new LinkedListQueue<>();
      int i = 0, j = 0;
      int aLen = a.size();
      int bLen = b.size();
      // System.out.println(a.size());
      // System.out.println(b.size());
      while (i < aLen && j < bLen) {
         // System.out.println(i);
         // System.out.println(j);
         if (a.first().compareTo(b.first()) < 0) {
            // System.out.println(a.first().compareTo(b.first()));
            newQ.enqueue(a.dequeue());
            i++;
         } else {
            // System.out.println(a.first().compareTo(b.first()));
            newQ.enqueue(b.dequeue());
            j++;
         }
      }
      while (!(a.isEmpty())) {
         newQ.enqueue(a.dequeue());
      }
      while (b.size() != 0) {
         newQ.enqueue(b.dequeue());
      }
      return newQ;
   }

   public static void main(String[] args) {
      MyQueue<Integer> a = new LinkedListQueue<>();
      MyQueue<Integer> b = new LinkedListQueue<>();
      a.enqueue(2);
      a.enqueue(4);
      a.enqueue(8);
      a.enqueue(10);
      b.enqueue(1);
      b.enqueue(4);
      b.enqueue(9);
      System.out.println(merge(a, b));
   }
}
