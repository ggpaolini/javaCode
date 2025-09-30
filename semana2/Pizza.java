import java.util.Scanner;

public class Pizza{

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = stdin.nextInt(); 
        }
        int p = stdin.nextInt();
        int count = 0;
        for (int i = 0; i < p; i++){
            boolean bool = true;
            int k = stdin.nextInt();
            for (int j = 0; j < k; j++){
                int b = stdin.nextInt();
                for (int l = 0; l < n; l++){
                    if (arr[l] == b) bool = false;
                }
            }
            if (bool) count++;
        }
        System.out.println(count);
    }
}