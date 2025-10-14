public class BooleanArrayIntSet implements IntSet {
   private int size;
   private boolean[] isElem;

   BooleanArrayIntSet(int n) {
      size = 0;
      isElem = new boolean[n + 1];
   }

   public boolean contains(int x) {
      return isElem[x];
   }

   public boolean add(int x) {
      if (size == isElem.length)
         throw new RuntimeException("Não da para meter mais elems no set");
      if (!contains(x)) {
         isElem[x] = true;
         size++;
         return true;
      }
      return false;
   }

   public boolean remove(int x) {
      if (contains(x)) {
         isElem[x] = false;
         size--;
         return true;
      }
      return false;
   }

   public int size() {
      return size;
   }

   public void clear() {
      for (int i = 0; i < isElem.length; i++) {
         isElem[i] = false;
      }
      size = 0;
   }

   public IntSet intersection(IntSet s) {
      IntSet newS = new BooleanArrayIntSet(1000000);
      for (int i = 0; i < isElem.length; i++) {
         if (this.contains(i) && s.contains(i))
            newS.add(i);
      }
      return newS;
   }

   public boolean equals(IntSet s) {
      if (this.size() != s.size())
         return false;
      for (int i = 0; i < isElem.length; i++) {
         if (s.contains(i) != this.contains(i))
            return false;
      }
      return true;
   }
}
