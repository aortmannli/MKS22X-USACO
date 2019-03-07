import java.util.*;
import java.io.*;
import java.util.Scanner;

public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
    int[][] grid;
    int depth = 0;
    //TODO: change to isntructions before end of lab
    int[][] stompDig; // instructions, im lazy maybe will chang before its due
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

    stompDig = new int[N][3];
    for (int x = 0; x < N; x++){
      for (int i = 0; i < 3; i++){
        stompDig[x][i] = Integer.parseInt(in.next());
      }
    }

    in.close();

    for(int[] i : stompDig){
      int r = i[0]-1;
      int c = i[1]-1;
      int stomp = i[2];
      int max = 0;


      for (int y = 0; y<3;y++) {
        for (int x = 0; x<3; x++) {
          if (max < grid[r+y][c+x]) {
            max = grid[r+y][c+x];
          }
        }
      }

      System.out.println("");
      System.out.println(max);

      max -= stomp;
      for (int y = 0; y<3;y++) {
        for (int x = 0; x<3; x++){
          if (grid[r+y][c+x] > max) {
            grid[r+y][c+x] = max;
          }
        }
      }

      System.out.println("");
      for (int y = 0; y < R; y++){
        for (int x = 0; x < C; x++){
          System.out.print(grid[y][x] + " ");
        }
        System.out.print("\n");
      }
    }


    for (int y = 0; y < R; y++) {
      for (int x = 0; x < C; x++) {
        if (grid[y][x] < E) {
          grid[y][x] = E-grid[y][x];
          depth += grid[y][x];
        }else {
          grid[y][x] = 0;
        }
      }
    }

    System.out.println(depth);

    return 72 * 72 * depth;
  }

  public static int silver(){
    /*fewer than two neighbouring valid spots or more than three valid spots is NO LONGER VALID
    any valid spot with two or three live neighboursremians valid
    any invalid cell with exactly three valid neighbours becomes a valid spot
    you cannot go on trees
    */
  }
  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(bronze("test.txt"));
  }
}
