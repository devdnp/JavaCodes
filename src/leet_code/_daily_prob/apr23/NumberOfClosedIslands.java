package leet_code._daily_prob.apr23;
//06Apr
//#1254
public class NumberOfClosedIslands {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }
    public static int closedIsland(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        // Remove lands connected to edge
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (i * j == 0 || i == m - 1 || j == n - 1)
                    if (grid[i][j] == 0)
                        dfs(grid, i, j);

        int ans = 0;

        // Reduce to 200. Number of Islands
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    ++ans;
                }

        return ans;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return;
        if (grid[i][j] == 1)
            return;

        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
