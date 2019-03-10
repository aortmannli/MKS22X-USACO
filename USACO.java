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

  public static int silver(String filename) throws FileNotFoundException{
    /*fewer than two neighbouring valid cell or more than three valid cells dies
    any live cell with two or three live neighbours remians live
    any dead cell with exactly three live neighbours becomes a live cell
    you cannot go on trees
    */

    File file = new File(filename);
    Scanner in = new Scanner(file);
    int R = in.nextInt();
    int C = in.nextInt();
    int T = in.nextInt();

    boolean[][] noTree = new boolean[R][C];
    int[][] grid = new int[R][C];

    for (int r = 0; r < R; r++) {
			String line = in.next();
			for (int c = 0; c < C; c++) {
				noTree[r][c] = (line.charAt(c) != '*');
			}
		}

    for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				grid[r][c] = 0;
			}
		}

    int r_s = in.nextInt()-1;
		int c_s = in.nextInt()-1;
		int r_e = in.nextInt()-1;
		int c_e = in.nextInt()-1;

    grid[r_s][c_e] = 1;
    for(int i = 0; i < T; i++){
      for(int y=0; y<grid.length; y++){
        for(int x=0; x<grid[y].length; x++){
          if(noTree[y][x]){
            if(grid[y][x] !=0){
              grid[y+1][x] += grid[y][x];
              grid[y][x+1] += grid[y][x];
              grid[y-1][x] += grid[y][x];
              grid[y][x-1] += grid[y][x];
            }
          }else{
            grid[y][x] = -1;
          }
        }
      }
    }

    return grid[r_e][c_e];
  }

  public static void mod(int[][]map, int r, int c, int num){

  }

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(bronze("test.txt"));
  }
}
