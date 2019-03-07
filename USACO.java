import java.util.*;
import java.io.*;

public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
    int[][] grid;
    int[][] instructions;
    int R,C,E,N;
    File file = new File(filename);
    Scanner in = new Scanner(file);
    R = Integer.parseInt(in.next());
    C = Integer.parseInt(in.next());
    E = Integer.parseInt(in.next());
    N = Integer.parseInt(in.next());
    grid = new int[R][C];
    for (int y = 0; y < R; y++){
      for (int x = 0; x < C; x++){
        grid[y][x] = Integer.parseInt(in.next());
        System.out.print(grid[y][x] + " ");
      }
      System.out.print("\n");
    }
     return 0;
  }

  public static void main(String[] args) throws FileNotFoundException{
    bronze("test.txt");
  }
}
