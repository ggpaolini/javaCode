import java.util.Arrays;

public class TestReverse {

   public static int[] revIter(int[] v, int start, int end) {
      for (int i = 0; i < end / 2; i++) {
         int tmp = v[i];
         v[start] = v[end - i];
         v[end] = tmp;
      }
      return v;
   }

   public static int[] revRec1(int[] v, int start, int end) {
      if (end - start == 1) {
         int tmp = v[start];
         v[start] = v[end];
         v[end] = tmp;
      } else {
         revRec1(v, start + 1, end - 1);
         int tmp = v[start];
         v[start] = v[end];
         v[end] = tmp;
      }
      return v;
   }

   public static int[] revRec2(int[] v, int start, int end) {
      if (start >= end)
         return v;
      int tmp = v[start];
      v[start] = v[end];
      v[end] = tmp;
      revRec2(v, start + 1, end - 1);
      return v;
   }

   public static void main(String[] args) {
      int[] v = { 1, 5, -5, 10, 4, 7 };
      System.out.println(Arrays.toString(v));
      // System.out.println(revIter(v, 0, 5));
      System.out.println(Arrays.toString(revRec2(v, 0, 5)));
   }
}
