import java.util.Scanner;

public class TestMaxCardinals{
    public static void MaxCardinals(int l, int c, char[][] arr){
        int max_count = 0;
        int n_count = 0;
        for (int i = 0; i< l; i++){
            int count = 0;
            for (int k = 0; k < c; k++){
                //System.out.println(i + " " + k + " " + arr[i][k] + " " + n_count + " " + count);
                if (arr[i][k] == '#'){
                    count++;
                }
                if (arr[i][k] != '#'){
                    if (count > max_count){
                        max_count = count;
                        n_count = 1;
                        
                    }
                    else if (count == max_count){
                        n_count++;
                        
                    }
                    count = 0;
                }
            }
            if (count == max_count) n_count++;
            else if (count > max_count){
                n_count = 1;
                max_count = count;
            }
        }
        for (int j = 0; j < c; j++){
            int count = 0;          
            for (int k = 0; k < l; k++){
                //System.out.println(j + " " + k + " " + arr[k][j] + " " + n_count + " " + count);            
                if (arr[k][j] == '#'){
                    count++;
                    //System.out.println("teste#");
                }
                if (arr[k][j] != '#'){
                    //System.out.println(count + " " + max_count);
                    if (count > max_count){
                        max_count = count;
                        n_count = 1;
                    }
                    else if (count == max_count){
                        n_count++;
                        //System.out.println("teste");
                    }
                    count = 0;
                }
            }
            if (count == max_count) n_count++;
            else if (count > max_count){
                n_count = 1;
                max_count = count;
            }
        }
        System.out.println(max_count + " " + n_count);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        char[][] arr = new char[l][c];
        for (int i = 0; i < l; i++){
                arr[i] = sc.next().toCharArray(); //sc.next retorna string
        }
        MaxCardinals(l, c, arr);
    }
}