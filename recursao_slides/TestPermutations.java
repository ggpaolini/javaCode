public class TestPermutations {

   public static void perm(int cur, int[] v) {
      if (cur == v.length - 1) {
         for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
         }
         System.out.println();
      } else {
         for (int i = cur; i < v.length; i++) {
            swap(v, cur, i);
            perm(cur + 1, v);
            swap(v, cur, i);
         }
      }
   }

   public static void swap(int[] v, int a, int b) {
      int tmp = v[a];
      v[a] = v[b];
      v[b] = tmp;
   }

   public static void perm1(int cur, int[] v, int[] tmp, boolean[] used) {
      if (cur == v.length) {
         for (int i = 0; i < v.length; i++)
            System.out.print(tmp[i] + " ");
         System.out.println();
      }

      else {
         for (int i = 0; i < v.length; i++) {
            if (!used[i]) {
               used[i] = true;
               tmp[cur] = v[i];
               perm1(cur + 1, v, tmp, used);
               used[i] = false;
            }
         }
      }
   }

   public static void main(String[] args) {
      int[] v = { 1, 2, 3 };
      perm(0, v);
   }
}
