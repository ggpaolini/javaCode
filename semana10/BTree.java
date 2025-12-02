// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Arvore binaria "normal"
// -----------------------------------------------------------

public class BTree<T> {
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {
      return root;
   }

   public void setRoot(BTNode<T> r) {
      root = r;
   }

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null)
         return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null)
         return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------

   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n == null)
         return false;
      if (n.getValue().equals(value))
         return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n == null)
         return;
      System.out.print(" " + n.getValue());
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n == null)
         return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n == null)
         return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");

      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");

      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

   public int numberLeafs() {
      if (root == null)
         return 0;
      return numberLeafs(root);
   }

   private int numberLeafs(BTNode<T> node) {
      if (node.getRight() == null && node.getLeft() == null)
         return 1;
      if (node.getLeft() == null)
         return numberLeafs(node.getRight());
      if (node.getRight() == null)
         return numberLeafs(node.getLeft());
      return numberLeafs(node.getRight()) + numberLeafs(node.getLeft());
   }

   public boolean strict() {
      if (root == null) {
         return false;
      }
      return strict(root);
   }

   private boolean strict(BTNode<T> node) {
      if (node.getRight() != null && node.getLeft() == null) {
         return false;
      }
      if (node.getRight() == null && node.getLeft() != null) {
         return false;
      }
      if (node.getRight() == null && node.getLeft() == null) {
         return true;
      }
      return strict(node.getLeft()) && strict(node.getRight());
   }

   public T path(String s) {
      if (s.equals("R"))
         return root.getValue();
      BTNode<T> cur = root;
      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == 'E')
            cur = cur.getLeft();
         else
            cur = cur.getRight();
      }
      return cur.getValue();
   }

   public int nodesLevel(int k) {
      return nodesLevel(0, k, root);
   }

   private int nodesLevel(int cur, int k, BTNode<T> node) {
      if (node == null)
         return 0;
      if (cur == k)
         return 1;
      return nodesLevel(cur + 1, k, node.getLeft()) + nodesLevel(cur + 1, k, node.getRight());
   }

}
