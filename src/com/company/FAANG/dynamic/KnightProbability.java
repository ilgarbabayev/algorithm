package com.company.FAANG.dynamic;

/*
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves.
The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
A chess knight has eight possible moves it can make, as illustrated below.
Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
 */

import java.util.LinkedList;
import java.util.Queue;

public class KnightProbability {

  public static void main(String[] args) {
    int n = 3; int k = 2; int row = 0; int column = 0; //expected 0.06250
    int n1 = 1; int k1 = 0; int row1 = 0; int column1 = 0; // expected 0
    int n2 = 3; int k2 = 3; int row2 = 0; int column2 = 0; // expected 0.01562

//    System.out.println(knightProbability(n, k, row, column));
//    System.out.println(knightProbability(n1, k1, row1, column1));
    System.out.println(knightProbability(n2, k2, row2, column2));
  }

  private static final int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

  public static double knightProbability(int n, int k, int row, int column) {
    double[][] dp = new double[n][n];
    dp[row][column] = 1.0;

    for(int move = 1; move<=k; move++) {
      double[][] ndp = new double[n][n];
      for(int r = 0; r<n; r++) {
        for(int c = 0; c<n; c++) {
          for(int[] m: moves) {
            int nr = r+m[0];
            int nc = c+m[1];
            if (isValid(nr, nc, n)) ndp[r][c] += dp[nr][nc]/8.0;
          }
        }
      }
      dp = ndp;
    }

    double prob = 0.0;
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        prob += dp[r][c];
      }
    }

    return prob;
  }

  private static boolean isValid(int r, int c, int n) {
    return r >= 0 && r < n && c >= 0 && c < n;
  }
}
