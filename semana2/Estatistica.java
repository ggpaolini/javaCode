import java.util.Scanner;

class Estatistica{

    static double media(int[] v){
        int n = v.length;
        double sum = 0;
        for (int i = 0; i< n; i++){
            sum += v[i];
        }
        return sum/n;
    }

    static int amplitude(int[] v){
        int max = v[0], min = v[0];
        for (int i = 1; i< v.length; i++){
            if (v[i] > max) max = v[i];
            else if (v[i] < min) min = v[i];
        }
        return max - min;
    }

        public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] v = new int[n];
        
        for ( int i = 0; i < n; i++){
            v[i] = stdin.nextInt();
        }
        System.out.printf("%.2f%n", media(v));
        System.out.println(amplitude(v));
    }
}