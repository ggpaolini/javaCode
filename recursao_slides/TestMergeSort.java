import java.util.Arrays;

public class TestMergeSort {
   public static void mergeSort(int[] v, int start, int end) {
      if (start == end)
         return;
      int middle = (start + end) / 2;
      mergeSort(v, start, middle);
      mergeSort(v, middle + 1, end);
      merge(v, start, end, middle);
   }

   public static void merge(int[] v, int start, int end, int middle) {
      int arr[] = new int[end - start + 1];
      int i = start;
      int j = middle + 1;
      int k = 0;
      while (i <= middle && j <= end) {
         if (v[i] <= v[j])
            arr[k++] = v[i++];
         else
            arr[k++] = v[j++];
      }
      while (i <= middle)
         arr[k++] = v[i++];
      while (j <= end)
         arr[k++] = v[j++];
      for (int c = 0; c < k; c++)
         v[start + c] = arr[c];
   }

   public static void main(String[] args) {
      int[] v = { 1, 5, -5, 10, 4, 7 };
      System.out.println(Arrays.toString(v));
      mergeSort(v, 0, 5);
      System.out.println(Arrays.toString(v));
   }
}
