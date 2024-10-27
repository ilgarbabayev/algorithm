package com.company.FAANG._2D_array;

/*
    You are given a m x n 2D grid initialized with these three possible values.

    -1 - A wall or an obstacle.
    0 - A gate.
    INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

    Example:

    Given the 2D grid:

    INF  -1  0  INF
    INF INF INF  -1
    INF  -1 INF  -1
      0  -1 INF INF
    After running your function, the 2D grid should be:

      3  -1   0   1
      2   2   1  -1
      1  -1   2  -1
      0  -1   3   4

 */

import java.util.Deque;
import java.util.LinkedList;

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        // get the number of rows and columns in the rooms grid
        int numRows = rooms.length;
        int numCols = rooms[0].length;

        // create a queue to hold the gate positions
        Deque<int[]> queue = new LinkedList<>();

        // find all gates (represented by 0) and add their positions to the queue
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // distance from the gate
        int distance = 0;
        // array to facilitate exploration in 4 directions: up, right, down, left
        int[] directions = {-1, 0, 1, 0, -1};

        // perform BFS starting from each gate
        while (!queue.isEmpty()) {
            ++distance;
            for (int i = queue.size(); i > 0; --i) {
                // get and remove the position from the front of the queue
                int[] position = queue.poll();
                for (int j = 0; j < 4; ++j) { // explore all 4 directions
                    int newRow = position[0] + directions[j];
                    int newCol = position[1] + directions[j + 1];
                    // if the new position is within bounds and is an empty room
                    // (denoted by Integer.MAX_VALUE), then update the distance
                    // and add the new position to the queue for further BFS
                    if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && rooms[newRow][newCol] == Integer.MAX_VALUE) {
                        rooms[newRow][newCol] = distance;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
    }
}
