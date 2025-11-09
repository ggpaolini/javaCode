public class ED195 {
   public static boolean balanced(String s) {
      MyStack<Character> pilha = new LinkedListStack<>();
      for (int i = 0; i < s.length(); i++) {
         // System.out.println(i);
         char ch = s.charAt(i);
         if (ch == '(' || ch == '[') {
            pilha.push(ch);
         } else if (ch == ')') {
            if (pilha.isEmpty())
               return false;
            if (pilha.top().equals('(')) {
               pilha.pop();
            } else
               return false;
         } else {
            if (pilha.isEmpty())
               return false;
            if (pilha.top().equals('['))
               pilha.pop();
            else
               // System.out.println("teste");
               return false;
         }
      }
      if (pilha.isEmpty())
         return true;
      else
         return false;
   }
   /*
    * public static void main(String[] args) {
    * System.out.println(balanced("([()])"));
    * System.out.println(balanced("(()]"));
    * }
    */
}
