//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];  // This will store the column position for each queen in a row.
        solveNQueens(n, 0, board, result);
        return result;
    }

    // Backtracking helper function
    private void solveNQueens(int n, int row, int[] board, ArrayList<ArrayList<Integer>> result) {
        // If all queens are placed, add the solution to the result
        if (row == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1);  // Convert 0-based index to 1-based position
            }
            result.add(solution);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            // Check if the queen can be placed at (row, col)
            if (isSafe(board, row, col)) {
                board[row] = col;  // Place the queen at (row, col)
                solveNQueens(n, row + 1, board, result);  // Recur to place queens in the next row
                board[row] = -1;  // Backtrack (remove the queen)
            }
        }
    }

    // Check if it's safe to place a queen at (row, col)
    private boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            // Check column conflict or diagonal conflicts
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;  // code here
    }
}