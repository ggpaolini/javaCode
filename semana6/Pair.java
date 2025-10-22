public class Pair {
   private int a, b;

   Pair(int a, int b) {
      this.a = a;
      this.b = b;
   }

   @Override
   // quando se chama o metodo procura pelo argumento com tipo object
   public boolean equals(Object p) {
      if (!(p instanceof Pair))
         return false;
      Pair pcopy = (Pair) p;
      return (this.a == pcopy.a && this.b == pcopy.b);
   }

   @Override
   public String toString() {
      return "(" + a + "," + b + ")";
   }
}
