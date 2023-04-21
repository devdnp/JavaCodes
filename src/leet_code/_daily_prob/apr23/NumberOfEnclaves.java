package leet_code._daily_prob.apr23;
//07Apr
//#1020
public class NumberOfEnclaves {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n-1 || j == m-1) && grid[i][j] == 1) {
                    dfs(grid,i, j);
                }
            }
        }

        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s += grid[i][j];
            }
        }
        return s;
    }
    public static void dfs(int[][] grid,int i ,int j){
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid,i+1, j);
        dfs(grid,i-1, j);
        dfs(grid,i, j+1);
        dfs(grid,i, j-1);
    }
}
