import java.util.Arrays;
// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// -----------------------------------------------------------

import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      for (int i = 0; i < n; i++) {
         BTree<Integer> t = LibBTree.readIntTree(in);
         System.out.println(ED213.maxSum(t));
      }
   }
}
