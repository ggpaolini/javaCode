import java.util.Scanner;

public class ED007 {
   public static void analisador(char[] arr) {
      MyStack<Character> pilha = new LinkedListStack<>();

      for (int j = 0; j < arr.length; j++) {
         if (arr[j] == '(' || arr[j] == '[') {
            pilha.push(arr[j]);
         }

         else if (arr[j] == ')') {
            if (pilha.size() == 0) {
               System.out.println("Erro na posicao " + j);
               return;
            }
            if (pilha.top() != '(' || pilha.size() == 0) {
               System.out.println("Erro na posicao " + j);
               return;
            } else
               pilha.pop();
         }

         else if (arr[j] == ']') {
            if (pilha.size() == 0) {
               System.out.println("Erro na posicao " + j);
               return;
            }
            if (pilha.top() != '[') {
               System.out.println("Erro na posicao " + j);
               return;
            } else
               pilha.pop();
         }
      }

      if (pilha.size() == 0)
         System.out.println("Expressao bem formada");
      else
         System.out.println("Ficam parenteses por fechar");
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      sc.nextLine();

      for (int i = 0; i < n; i++) {
         char[] expression = sc.nextLine().toCharArray();
         analisador(expression);
      }
   }
}
