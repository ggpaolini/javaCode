import java.util.Scanner;

class Losango{
    public static void desenharLosango(int n){
        for (int i = 0; i<= n/2; i++){
            for (int j = i; j < n/2; j++) System.out.print(".");
            for (int j = 0; j < i*2 + 1; j++) System.out.print("#");
            for (int j = i; j < n/2; j++) System.out.print(".");
            System.out.println();
        }
        for (int i = n/2 -1; i>= 0; i--){
            for (int j = i; j < n/2; j++) System.out.print(".");
            for (int j = 0; j < i*2 + 1; j++) System.out.print("#");
            for (int j = i; j < n/2; j++) System.out.print(".");
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        desenharLosango(n);
    }
}