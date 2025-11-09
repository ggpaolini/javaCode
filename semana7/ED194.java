// Pode submeter uma classe como esta.
// - No seu computador pode testar com "java ED194"
// - O mooshak apenas irá chamar o seu método reverse
public class ED194 {

   // Método que deve implementar
   public static void reverse(MyStack<Integer> s, int n) {
      Integer[] arr = new Integer[n];
      for (int i = 0; i < n; i++) {
         arr[i] = s.pop();
      }
      for (int i = 0; i < n; i++) {
         s.push(arr[i]);
      }
   }

   // Main apenas para testar no seu computador
   public static void main(String[] args) {
      MyStack<Integer> s = new LinkedListStack<Integer>();

      for (int i = 5; i > 0; i--)
         s.push(i);
      System.out.println(s); // Antes da chamada a reverse
      reverse(s, 3);
      System.out.println(s); // Depois da chamada a reverse
   }
}
