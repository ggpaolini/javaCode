public class MySinglyLinkedList<T> {
   private Node<T> first;
   private int size;

   MySinglyLinkedList() {
      first = null;
      size = 0;
   }

   public int size() {
      return size;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public T getFirst() {
      if (isEmpty())
         return null;
      return first.getValue();
   }

   public T getLast() {
      if (isEmpty())
         return null;
      Node<T> cur = first;
      while (cur.getNext() != null) {
         cur = cur.getNext();
      }
      return cur.getValue();
   }

   public void addFirst(T value) {
      Node<T> newNode = new Node<T>(value, first);
      first = newNode;
      size++;
   }

   public void removeFirst() {
      if (isEmpty())
         return;
      first = first.getNext();
      size--;
   }

   public void removeLast() {
      if (isEmpty())
         return;
      Node<T> cur = first;
      if (size == 1)
         first = null;
      while (cur.getNext().getNext() != null)
         cur = cur.getNext();
      cur.setNext(null);

   }

   public void addLast(T value) {
      Node<T> newNode = new Node<T>(value, null);
      if (isEmpty())
         first = newNode;
      else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);
      }
      size++;
   }

   public String toString() {
      String str = "{";
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null)
            str += ", ";
      }
      str += "}";
      return str;
   }
}
