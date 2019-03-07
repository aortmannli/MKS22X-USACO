import java.util.*;
import java.io.*;
import java.util.Scanner;

public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
    int[][] grid;
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

    //in.close();

    for(int[] i : stompDig){
      int[] elev = new int[9];
      int count = 0;
      for(int x = -1; x < 2; x++){
          elev[count] = grid[i[0] + x][i[1] + x];
          count++;
      }

      insertionSort(elev);

      for (int g = 0; g < i[2]; g++){
        for(int f = -1; f < 2; f++){
          if (grid[i[0] + f][i[1] + f] == elev[8] - g) {
            grid[i[0] + f][i[1] + f]--;
          }
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

    int depth = 0;
    for (int y = 0; y < R; y++) {
      for (int x = 0; x < C; x++) {
        grid[y][y] = E - grid[y][x];
        if (grid[y][x] > 0) {
            depth += grid[y][x];
        }
      }
    }

    return 72 * 72 * depth;
  }

  public static void insertionSort(int[] data){
      for(int i = 1; i < data.length; i++){
        int current = data[i];
        boolean sorted = false;
        int idx = i-1;
        while(!(idx < 0 || data[idx] < current)){
          data[idx+1] = data[idx];
          idx--;
        }
        data[idx+1] = current;
      }
    }

  public static void main(String[] args) throws FileNotFoundException{
    bronze("test.txt");
  }
}
