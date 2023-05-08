package leet_code._daily_prob.may23;
//08-May-2023
//#1572
public class MatrixDiagonalSum {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalSum(mat));
    }
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i=0, end=mat.length -1; i<mat.length; i++, end--) {
            sum += mat[i][i] + mat[i][end];
            if (i == end)
                sum -= mat[i][end];
        }
        return sum;
    }
}