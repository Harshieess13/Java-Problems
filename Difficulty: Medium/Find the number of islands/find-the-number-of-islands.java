//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    int[][] dic = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0, x, y;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isV = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!isV[i][j] && grid[i][j] == '1') {
                    ans++;
                    q.add(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] c = q.poll();
                        x = c[0];
                        y = c[1];
                        if (x < 0 || y < 0 || x >= n || y >= m || isV[x][y] || grid[x][y] == '0')
                            continue;
                        isV[x][y] = true;
                        for (int[] k : dic)
                            q.add(new int[] { x + k[0], y + k[1] });
                    }
                }
        return ans;
    }

}