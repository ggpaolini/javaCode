// ------------------------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// ------------------------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples 
// ------------------------------------------------------------------------

public class TestSinglyLinkedList {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Pair> list = new SinglyLinkedList<Pair>();

      // Escrevendo lista (no inicio esta vazia)
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i = 1; i <= 3; i++) {
         for (int j = 1; j <= 3; j++) {
            Pair p = new Pair(i, j);
            list.addLast(p);
         }
      }
      System.out.println(list);

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
