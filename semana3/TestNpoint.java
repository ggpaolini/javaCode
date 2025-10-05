import java.util.Scanner;

public class TestNpoint{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Npoint p = new Npoint(n, sc);
        p.toString1();
        
    }
}