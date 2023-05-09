package leet_code._daily_prob.may23;

import java.util.ArrayList;
import java.util.List;

//09-May-2023
//#54
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int count = 0, total = m * n;
        int rowStart = 0, endRow = m - 1;
        int colStart = 0, endCol = n - 1;

        while (count < total) {
            // Top row (L --> R)
            for (int i = colStart; count < total && i <= endCol; i++) {
                ans.add(matrix[rowStart][i]);
                count++;
            }
            rowStart++;

            // Right column (T --> B)
            for (int i = rowStart; count < total && i <= endRow; i++) {
                ans.add(matrix[i][endCol]);
                count++;
            }
            endCol--;

            // Bottom row (R --> L)
            for (int i = endCol; count < total && i >= colStart; i--) {
                ans.add(matrix[endRow][i]);
                count++;
            }
            endRow--;

            // Left column (B --> T)
            for (int i = endRow; count < total && i >= rowStart; i--) {
                ans.add(matrix[i][colStart]);
                count++;
            }
            colStart++;
        }

        return ans;
    }
}