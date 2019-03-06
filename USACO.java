import java.util.*;
import java.io.*;

public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
    char[][] grid;
    int R,C,E,N;
    File f = new File(filename);
    Scanner in = new Scanner(f);

    String ln = in.nextLine();
    R = ln.charAt(0) - '0';
    System.out.print(R);
    C = ln.charAt(2) - '0';
    E = ln.charAt(4) - '0';
    N = ln.charAt(6) - '0';

    grid = new char[R][C];

    for(int x = 0; x < R; x++){
       String line = in.nextLine();
       for(int y = 0; y < line.length(); y++){
          grid[x][y] = line.charAt(y);
          System.out.println(grid[x][y]);
       }
     }

     return 0;
  }

  public static void main(String[] args) throws FileNotFoundException{
    bronze("test.txt");
  }
}
