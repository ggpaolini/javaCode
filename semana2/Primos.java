import java.util.Scanner;

public class Primos{
    public static int eratostenesCrivo(int a, int b){
        boolean[] notPrime = new boolean[b+1];
        for(int p = 2; p <= b; p++){
            if (!notPrime[p]){
                for (int i = 2; p*i <=b; i++){
                    notPrime[p*i] = true;
                }
            }
        }
        int count = 0;
        for (int i = a; i <=b; i++){
            if (!notPrime[i]){
                count++;
                //System.out.println(i);
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int a, b;
        a = stdin.nextInt();
        b = stdin.nextInt();
        System.out.println(eratostenesCrivo(a, b)); //crivo = peneira
    }
}