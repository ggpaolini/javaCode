public class Extras {
    public static void losango(int n){
        //primeira parte do losango
        for (int i = 0; i <= n/2; i++){
            for (int j = 0; j < n/2 -i; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i +1; j++){
                System.out.print("#");
            }
            for (int j = 0; j < n/2 -i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        //segunda parte
        for ( int i = n/2 -1; i >= 0; i--){
            for (int j = 0; j < n/2 -i; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i +1; j++){
                System.out.print("#");
            }
            for (int j = 0; j < n/2 -i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void primeFactorization(int n){
        //vou usar o metodo que está em Primes.java
        int i = 2;
        int nCopy = n;
        while (nCopy != 1){
            if (!Primes.isPrime(i) || nCopy % i != 0){
                i++;
                continue;
            }
            if (nCopy == n) System.out.print(n + " = " + i);
            else System.out.print(" * " + i);
            nCopy /= i;
        }
        System.out.println();
    }
    public static void count(String str, char ch){
        //no ex diz para retornar o numero em vez de print
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch) count++;
        }
        System.out.println(count);
    }
    public static void lSystem(int n){
        // é o l system original criado por Lindenmayer (biologo)
        if (n < 1) return;
        String str = "A";
        for (int i = 0; i < n; i++){
            String strCopy = "";
            System.out.println(str);
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == 'A') strCopy+= "AB";
                else strCopy += "A";
            }
            str = strCopy;
        }
    }
    public static void primeFactorization1(int n ){
     int cur = 2;
     boolean first = true;
     System.out.print(n + " =");
     while (n != 1){
        if (Primes.isPrime(cur)){
            if (n % cur == 0){
                if (!first) System.out.print(" *");
                n /= cur;
                System.out.print(" " + cur);
                first = false;
                continue;
            }
        }   
        cur++;
     }
     System.out.println();
    }
    public static void count1(String str, char ch){
        int len = str.length(), count = 0;
        for (int i = 0; i < len; i++){
            if (str.charAt(i) == ch) count++;
        }
        System.out.println(count);
    }
    public static void main(String args[]){
        losango(4);
        primeFactorization1(20);
        count1("algoritmo", 'o');
        lSystem(7);
    }
}
