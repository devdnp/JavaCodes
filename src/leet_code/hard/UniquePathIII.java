package leet_code.hard;
//980
public class UniquePathIII {
    static int res = 0;
    static int uniquePathsIII(int[][] grid) {
        int sx = 0, sy = 0, empty = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }

        dfs(sx, sy, empty, 0, grid);
        return res;
    }

    static  int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static void dfs(int x, int y, int targetCnt, int curCnt, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }

        if (grid[x][y] == 2 && curCnt == targetCnt + 1) {
            res++;
            return;
        }

        int val = grid[x][y];
        grid[x][y] = -2;
        for (int[] dir: dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            dfs(nextX, nextY, targetCnt, curCnt + 1, grid);
        }
        grid[x][y] = val;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(uniquePathsIII(grid));
    }
}
