package leet_code._daily_prob.may23;
//10-May-2023
//#59
import java.util.Arrays;

public class SpiralMatrixII {

    public static void main(String[] args) {
        int n =3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num;
                num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num;
                num++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num;
                    num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return matrix;
    }
}