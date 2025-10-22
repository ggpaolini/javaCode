// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Lista ligada simples
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first; // Primeiro no da lista
   private int size; // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   public SinglyLinkedList<T> concat(SinglyLinkedList<T> list) {
      SinglyLinkedList<T> newList = new SinglyLinkedList<>();
      Node<T> cur = first;
      while (cur != null) {
         newList.addLast(cur.getValue());
         cur = cur.getNext();
      }
      cur = list.first;
      while (cur != null) {
         newList.addLast(cur.getValue());
         cur = cur.getNext();
      }
      return newList;
   }

   public SinglyLinkedList<T> concatEstupido(SinglyLinkedList<T> list) {
      if (list.isEmpty())
         return this;
      if (this.isEmpty()) {
         return list;
      }
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      cur.setNext(list.first);
      size += list.size;
      return this;
   }

   public void removeEven() {
      if (size == 0)
         return;
      if (size == 1) {
         removeFirst();
         return;
      } // ou removeLast();
      removeFirst();
      Node<T> cur = first;
      int pos = 1;
      while (cur.getNext() != null) {
         if (pos % 2 == 0) {
            cur.setNext(cur.getNext().getNext());
            size--;
         } else {
            cur = cur.getNext();
         }
         pos++;
      }
      if (pos % 2 == 0)
         removeLast();
   }

   public int lastOccursAt(T value) {
      int pos = 0;
      int last = -1;
      Node<T> cur = first;
      while (cur != null) {
         if (cur.getValue().equals(value))
            last = pos;
         pos++;
      }
      return last;
   }

   public int occursAt(T value) {
      int pos = 0;
      Node<T> cur = first;
      while (cur != null) {
         if (cur.getValue().equals(value))
            return pos;
         pos++;
      }
      return -1;
   }

   public void removeAll(T value) {
      if (size == 0)
         return;
      while (first.getValue().equals(value)) {
         removeFirst();
         if (size == 0)
            return;
      }
      if (size == 0)
         return;
      Node<T> cur = first;
      while (cur.getNext() != null) {
         if (cur.getNext().getValue().equals(value)) {
            cur.setNext(cur.getNext().getNext());
            size--;
         } else
            cur = cur.getNext();
      }
   }

   public int count(T value) {
      int count = 0;
      Node<T> cur = first;
      while (cur != null) {
         if (cur.getValue().equals(value)) {
            count++;
         }
         cur = cur.getNext();
      }
      return count;
   }

   public void duplicate() {
      Node<T> cur = first;
      for (int i = 0; i < size; i++) {
         Node<T> newNode = new Node<T>(cur.getValue(), cur.getNext());
         cur.setNext(newNode);
         cur = newNode.getNext();
      }
      size += size;
   }

   public SinglyLinkedList<T> copy() {
      SinglyLinkedList<T> newList = new SinglyLinkedList<>();
      if (size == 0)
         return newList;
      Node<T> cur = first;
      while (cur.getNext() != null) {
         newList.addLast(cur.getValue());
         cur = cur.getNext();
      }
      newList.addLast(cur.getValue());
      return newList;
   }

   public T remove(int pos) {
      if (pos > size - 1 || pos < 0)
         return null;
      if (pos == 0) {
         Node<T> tmp = first;
         first = first.getNext();
         size--;
         return tmp.getValue();
      }
      Node<T> cur = first;
      for (int i = 0; i < pos - 1; i++) {
         cur = cur.getNext();
      }
      size--;
      Node<T> tmp = cur.getNext();
      cur.setNext(tmp.getNext());
      return tmp.getValue();
   }

   public T get(int pos) {
      if (pos > size - 1 || pos < 0)
         return null;
      Node<T> cur = first;
      for (int i = 0; i < pos; i++) {
         cur = cur.getNext();
      }
      return cur.getValue();
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
