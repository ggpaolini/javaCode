import java.util.Arrays;

public class TestMax {

   public static int maxIter(int[] v, int start, int end) {
      int maxSoFar = v[start];
      for (int i = start + 1; i <= end; i++) {
         if (v[i] > maxSoFar)
            maxSoFar = v[i];
      }
      return maxSoFar;
   }

   public static int maxRec(int[] v, int start, int end) {
      if (start == end)
         return v[start];
      return Math.max(v[start], maxRec(v, start + 1, end));
   }

   public static void main(String[] args) {
      int[] v = { 1, 5, -5, 10, 4, 7 };
      System.out.println(Arrays.toString(v));
      System.out.println(maxIter(v, 0, 5));
      System.out.println(maxRec(v, 0, 5));
   }
}
