import java.util.Scanner;

public class ED282 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int n = sc.nextInt();
      MyQueue<Cliente> fila = new LinkedListQueue<>();
      for (int i = 0; i < n; i++) {
         String nome = sc.next();
         int tvs = sc.nextInt();
         Cliente c = new Cliente(nome, tvs);
         fila.enqueue(c);
      }

      int dia = 1, tvs_dia = 0, tvs_total = 0;
      boolean atendido = false;
      Cliente cliente_atendido = null;
      while (fila.size() != 0) {
         Cliente c = fila.first();
         if (c.equals(cliente_atendido)) {
            tvs_total += tvs_dia;
            tvs_dia = 0;
            atendido = false;
            cliente_atendido = null;
            dia++;
            continue;
         }
         c = fila.dequeue();
         for (int i = 0; i < t; i++) {
            c.tvs--;
            tvs_dia++;
            if (c.tvs == 0) {
               tvs_total += tvs_dia;
               System.out.println(c.name + " " + dia + " " + tvs_dia + " " + tvs_total);
               tvs_total -= tvs_dia;
               break;
            }
         }
         if (c.tvs > 0) {
            if (!atendido) {
               fila.enqueue(c);
               cliente_atendido = c;
               atendido = true;
            } else {
               fila.enqueue(c);
            }
         }
      }
   }
}

class Cliente {
   String name;
   int tvs;

   Cliente(String nome, int sla) {
      name = nome;
      tvs = sla;
   }
}
