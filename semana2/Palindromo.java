import java.util.Scanner;

public class Palindromo{
    
    public static boolean isPalindrome1(String line){
        String str = "";
        for (int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);
            if (Character.isLetter(ch)){
                str = str + Character.toLowerCase(ch);
            }
        }
        int len = str.length();
        for (int i = 0; i < len/2; i++){
            if (str.charAt(i) != str.charAt(len-i-1)) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String str){
        String lowerString = str.toLowerCase();
        String newString = lowerString.replaceAll("\\W", ""); 
        //tbm podia so criar uma string limpa via ciclo e o metodo isLetter
        int len = newString.length();
        for (int i = 0; i < len/2; i++){
            if (newString.charAt(i) != newString.charAt(len-i-1)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        stdin.nextLine(); //limpar que ficou na linha do int
        System.out.println(n);
        for (int i = 0; i< n; i++){
            String line = stdin.nextLine();
            //System.out.print(line + ": ");
            if (isPalindrome(line)) System.out.println("sim");
            else System.out.println("nao");
        }
    }

}