
// ou floodfill
import java.util.Scanner;

public class TestDfs {
   static char[][] arr;
   static int r, c;
   static boolean visited[][];

   public static int dfsCount(int i, int j) {
      if (i < 0 || i >= r || j < 0 || j >= c)
         return 0;
      if (arr[i][j] == '.')
         return 0;
      if (visited[i][j])
         return 0;
      visited[i][j] = true;
      int count = 1;
      count += dfsCount(i + 1, j);
      count += dfsCount(i, j + 1);
      count += dfsCount(i - 1, j);
      count += dfsCount(i, j - 1);
      return count;

   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      r = sc.nextInt();
      c = sc.nextInt();
      arr = new char[r][c];
      visited = new boolean[r][c];
      for (int i = 0; i < r; i++) {
         arr[i] = sc.next().toCharArray();
      }
      System.out.println(dfsCount(0, 0));
      System.out.println(dfsCount(4, 6));
      System.out.println(dfsCount(2, 6));

   }
}
