public class ArrayListIntSet implements IntSet {
   private int size;
   private int[] arr;

   ArrayListIntSet(int maxSize) {
      arr = new int[maxSize];
      size = 0;
   }

   public IntSet intersection(IntSet s) {
      IntSet newSet = new ArrayListIntSet(100);
      for (int i = 0; i < this.size; i++) {
         if (s.contains(this.arr[i]))
            newSet.add(arr[i]);
      }
      return newSet;
   }

   public boolean equals(IntSet s) {
      if (!(this.size() == s.size()))
         return false;
      for (int i = 0; i < size; i++) {
         if (!s.contains(arr[i]))
            return false;
      }
      return true;
   }

   public boolean contains(int x) {
      for (int i = 0; i < size; i++) {
         if (arr[i] == x)
            return true;
      }
      return false;
   }

   public boolean add(int x) {
      if (!contains(x)) {
         if (size == arr.length)
            throw new RuntimeException("Maximum size of set reached");
         arr[size] = x;
         size++;
         return true;
      }
      return false;
   }

   public boolean remove(int x) {
      if (contains(x)) {
         int idx = 0;
         while (arr[idx] != x)
            idx++;
         arr[idx] = arr[--size];
         return true;
      }
      return false;
   }

   public void clear() {
      size = 0;
   }

   public int size() {
      return size;
   }

   @Override
   public String toString() {
      String res = "{";
      for (int i = 0; i < size; i++) {
         if (i > 0)
            res += ",";
         res += arr[i];
      }
      res += "}";
      return res;
   }
}
