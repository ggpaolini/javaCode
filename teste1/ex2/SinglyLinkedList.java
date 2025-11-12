// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first; // Primeiro no da lista
   private int size; // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }

   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first);
      first = newNode;
      size++;
   }

   public SinglyLinkedList<T> remove(int[] pos) {
      SinglyLinkedList<T> newList = new SinglyLinkedList<>();
      if (pos.length == 0) {
         Node<T> cur = first;
         while (cur != null) {
            newList.addLast(cur.getValue());
            cur = cur.getNext();
         }
         return newList;
      }
      Node<T> cur1 = first;
      Node<T> cur2 = newList.first;
      int j = 0;
      for (int i = 0; i < size; i++) {
         if (i == pos[j]) {
            cur1 = cur1.getNext();
            if (j < pos.length - 1)
               j++;
            else
               ;
         } else {
            if (cur2 == null) {
               Node<T> newNode = new Node<>(cur1.getValue(), null);
               newList.first = newNode;
               cur2 = newNode;
               newList.size++;
            } else {
               Node<T> newNode = new Node<>(cur1.getValue(), null);
               cur2.setNext(newNode);
               cur2 = cur2.getNext();
               newList.size++;
            }
            cur1 = cur1.getNext();
         }
      }
      return newList;
   }

   public void duplicate(int pos) {
      Node<T> cur = first;
      for (int i = 0; i < pos; i++) {
         cur = cur.getNext();
      }
      Node<T> newNode = new Node<T>(cur.getValue(), cur.getNext());
      cur.setNext(newNode);
      size++;
   }

   public void shift(int k) {
      k = k % this.size;
      Node<T> last = this.first;
      while (last.getNext() != null)
         last = last.getNext();
      last.setNext(this.first);
      for (int i = 0; i < this.size - k; i++) {
         last = last.getNext();
      }
      this.first = last.getNext();
      last.setNext(null);
   }

   public SinglyLinkedList<T> cut(int a, int b) {
      SinglyLinkedList<T> newList = new SinglyLinkedList<>();
      Node<T> cur = first;
      for (int i = 0; i < a; i++) {
         cur = cur.getNext();
      }
      for (int i = a; i <= b; i++) {
         newList.addLast(cur.getValue());
         cur = cur.getNext();
      }
      return newList;
   }

   public boolean isInside(T value) {
      Node<T> cur = first;
      while (cur != null) {
         if (cur.getValue().equals(value))
            return true;
         cur = cur.getNext();
      }
      return false;
   }

   public void remove(SinglyLinkedList<T> toRemove) {
      while (toRemove.isInside(first.getValue())) {
         this.removeFirst();
         if (this.size == 0)
            return;
      }
      Node<T> cur = this.first;
      if (cur.getNext() == null) {
         this.removeLast();
         return;
      }
      while (cur.getNext() != null) {
         if (toRemove.isInside(cur.getNext().getValue())) {
            cur.setNext(cur.getNext().getNext());
            size--;
         } else
            cur = cur.getNext();
      }
      if (toRemove.isInside(cur.getValue())) {
         this.removeLast();
         return;
      }
   }

   public int[] occurrences(T elem) {
      int[] arr = new int[size];
      Node<T> cur = first;
      int j = 0;
      for (int i = 0; i < size; i++) {
         if (cur.getValue().equals(elem)) {
            arr[j++] = i;
         }
         cur = cur.getNext();
      }
      if (j == 0)
         return null;
      else {
         int[] arrfinal = new int[j];
         for (int i = 0; i < j; i++) {
            arrfinal[i] = arr[i];
         }
         return arrfinal;
      }
   }

   public SinglyLinkedList<T> reverse() {
      SinglyLinkedList<T> newList = new SinglyLinkedList<>();
      Node<T> cur = first;
      while (cur != null) {
         newList.addFirst(cur.getValue());
         cur = cur.getNext();
      }
      return newList;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null);
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty())
         return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty())
         return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty())
         return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty())
         return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i = 0; i < size - 2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }

   // Converte a lista para uma String
   public String toString() {
      String str = "{";
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null)
            str += ",";
      }
      str += "}";
      return str;
   }
}
