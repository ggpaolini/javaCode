import java.util.Scanner;

public class ED005 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      sc.nextLine();

      for (int i = 0; i < n; i++) {
         int breaked = 0;
         MyStack<Integer> pilha = new LinkedListStack<>();
         String expression = sc.nextLine();
         String[] tokens = expression.split(" ");

         for (int j = 0; j < tokens.length; j++) {
            String token = tokens[j];
            if (Character.isDigit(token.charAt(0))) {
               pilha.push(Integer.parseInt(token));
            } else {
               if (pilha.size() < 2) {
                  System.out.println("Expressao Incorrecta");
                  breaked = 1;
                  break;
               }

               Integer n2 = pilha.pop();
               Integer n1 = pilha.pop();
               char op = token.charAt(0);

               if (op == '+')
                  pilha.push(n1 + n2);
               else if (op == '-')
                  pilha.push(n1 - n2);
               else if (op == '*')
                  pilha.push(n1 * n2);
               else if (op == '/')
                  pilha.push(n1 / n2);
            }
         }
         if (breaked == 1)
            continue;
         if (pilha.size() == 1)
            System.out.println(pilha.pop());
         else
            System.out.println("Expressao Incorrecta");
      }
   }
}
