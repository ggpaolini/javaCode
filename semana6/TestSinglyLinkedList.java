// ------------------------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// ------------------------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples 
// ------------------------------------------------------------------------

public class TestSinglyLinkedList {
   public static void main(String[] args) {
      /*
       * SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
       * SinglyLinkedList<Integer> vazio = list.copy();
       * System.out.println(vazio);
       * 
       * for (int i = 1; i <= 5; i++) {
       * list.addLast(i);
       * }
       * list.addLast(1);
       * list.addLast(2);
       * list.addLast(2);
       * list.addLast(2);
       * list.addLast(1);
       * list.addLast(3);
       * list.addLast(4);
       * list.addLast(2);
       * list.addLast(1);
       * list.removeAll(1);
       * System.out.println(list);
       */
      /*
       * System.out.println(list.get(0));
       * System.out.println(list.get(1));
       * System.out.println(list.get(2));
       * System.out.println(list.get(3));
       * System.out.println(list.get(4));
       * System.out.println(list.get(5));
       * System.out.println(list.get(-1));
       * System.out.println(list.get(6));
       */
      // System.out.println(list.size());
      // System.out.println(list.get(3));
      // System.out.println(list.remove(0));
      // list.duplicate();
      // System.out.println(list);
      // Criacao de lista de inteiros
      SinglyLinkedList<Pair> list = new SinglyLinkedList<Pair>();
      /*
       * // Escrevendo lista (no inicio esta vazia)
       * System.out.println(list);
       * 
       * // Verificando se esta vazia
       * System.out.println("isEmpty? " + list.isEmpty());
       */
      for (int i = 1; i <= 3; i++) {
         for (int j = 1; j <= 3; j++) {
            Pair p = new Pair(i, j);
            list.addLast(p);
         }
      }
      Pair p0 = new Pair(1, 2);
      System.out.println(list.count(p0));

      /*
       * // Adicionando numeros de 6 a 10 ao inicio da lista
       * for (char i = 6; i <= 10; i++) // char = 1... sao chars de controlo ficam
       * invisiveis
       * list.addFirst(i);
       * System.out.println(list);
       * 
       * // Verificando o tamanho da lista
       * System.out.println("size = " + list.size());
       * 
       * // Retirando o primeiro elemento
       * list.removeFirst();
       * System.out.println(list);
       * 
       * // Retirando o ultimo elemento
       * list.removeLast();
       * System.out.println(list);
       * 
       * // Verificando se esta vazia
       * System.out.println("isEmpty? " + list.isEmpty());
       * 
       * // Escreve o primeiro e ultimo elementos
       * System.out.println("getFirst() = " + list.getFirst());
       * System.out.println("getLast() = " + list.getLast());
       */
   }
}
