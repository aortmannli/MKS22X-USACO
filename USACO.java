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

      int[] elevations = new int[9];
      for(int b = 0; b < 9; b++){
        for (int y = 0; y<3;y++) {
          for (int z = 0; z<3; z++) {
            elevations[b] = grid[r + y][c + z];
          }
        }
      }



      System.out.println(elevations[8]);
      max = elevations[8];
/*
      for (int y = 0; y<3;y++) {
        for (int z = 0; z<3; z++) {
          if (max < grid[r+y][c+z]) {
            max = grid[r+y][c+z];
          }
        }
      }*/

      System.out.println(max);

      max -= stomp;
      for (int y = 0; y<3;y++) {
        for (int z = 0; z<3; z++){
          if (grid[r+y][c+z] > max) {
            grid[r+y][c+z] = max;
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
    System.out.println(bronze("test.txt"));
  }
}
