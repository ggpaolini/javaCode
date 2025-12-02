public class ED212 {
   public static int[] sumLevels(BTree<Integer> t) {
      int depth = t.depth();
      int[] arr = new int[depth + 1];
      for (int i = 0; i < depth + 1; i++) {
         arr[i] = sumLevel(i, 0, t.getRoot());
      }
      return arr;
   }

   private static int sumLevel(int l, int cur, BTNode<Integer> node) {
      if (node == null)
         return 0;
      if (cur == l)
         return node.getValue();
      return sumLevel(l, cur + 1, node.getLeft()) + sumLevel(l, cur + 1, node.getRight());
   }
}
