package leet_code._daily_prob;

public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        String[] strs = {"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(strs));
    }
    static int minDeletionSize(String[] A) {
        int deleted = 0;
        if (A == null || A.length == 0) return deleted;
        int rowSize = A[0].length();

        for (int col = 0; col < rowSize; col++){
            if (!isSorted(A, col)) deleted++;
        }

        return deleted;
    }

    static boolean isSorted(String[] A, int col){
        int N = A.length;
        char prev = (char)0;
        for (int i = 0; i < N; i++){
            char c = A[i].charAt(col);
            if (c < prev) return false;
            prev = c;
        }

        return true;
    }
}
