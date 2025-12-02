public class ED213 {
   private static String path = "";
   private static int bestSum = 0;

   public static String maxSum(BTree<Integer> t) {
      bestSum = 0;
      maxSum(t.getRoot(), 0, "");
      return path;
   }

   private static void maxSum(BTNode<Integer> node, int sum, String str) {
      if (node == null)
         return;
      sum += node.getValue();
      if (node.getLeft() == null && node.getRight() == null) {
         if (sum > bestSum) {
            bestSum = sum;
            path = str;
         }
      }
      maxSum(node.getRight(), sum, str + "D");
      maxSum(node.getLeft(), sum, str + "E");
   }
}
