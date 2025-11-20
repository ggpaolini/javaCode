public class TestSubSets {

   public static void subSets(int cur, int[] v, boolean[] used) {
      if (cur == v.length) {
         for (int i = 0; i < v.length; i++) {
            if (used[i]) {
               System.out.print(v[i] + " ");
            }
         }
         System.out.println();
      }

      else {
         used[cur] = true;
         subSets(cur + 1, v, used);
         used[cur] = false;
         subSets(cur + 1, v, used);
      }
   }

   public static void main(String[] args) {
      int[] v = { 1, 2, 3 };
      boolean[] used = new boolean[3];
      subSets(0, v, used);
   }
}
