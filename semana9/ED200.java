import java.util.Scanner;

public class ED200 {

   public static int floodfill(char[][] arr, int i, int j, boolean[][] visited) {
      if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length)
         return 0;
      if (visited[i][j])
         return 0;
      if (arr[i][j] == '.')
         return 0;
      int count = 1;
      visited[i][j] = true;
      count += floodfill(arr, i + 1, j, visited);
      count += floodfill(arr, i, j + 1, visited);
      count += floodfill(arr, i - 1, j, visited);
      count += floodfill(arr, i, j - 1, visited);
      count += floodfill(arr, i - 1, j - 1, visited);
      count += floodfill(arr, i + 1, j + 1, visited);
      count += floodfill(arr, i + 1, j - 1, visited);
      count += floodfill(arr, i - 1, j + 1, visited);
      return count;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for (int caso = 0; caso < n; caso++) {
         int l = sc.nextInt();
         int c = sc.nextInt();
         sc.nextLine();
         char[][] arr = new char[l][c];
         for (int i = 0; i < l; i++) {
            arr[i] = sc.nextLine().toCharArray();
         }
         int max = 0;
         boolean[][] visited = new boolean[l][c];
         for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
               int tmp = floodfill(arr, i, j, visited);
               if (tmp > max)
                  max = tmp;
            }
         }
         System.out.println(max);
      }
   }
}
