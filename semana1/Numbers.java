package semana1;

public class Numbers{
    public static void main(String[] args){
        int n = 10, count = 0;
        
        System.out.println("Numeros de 1 a " + n + ":"); // + é o operador de concatenação de strings
                  
        for (int i = 1; i <= n; i++){
            count+=i;
            if (i == n) System.out.println(i);
            else System.out.print(i + ", ");
        }
        System.out.println("Soma = " + count);
    }

}