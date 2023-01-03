package leet_code.easy;

public class DeleteColumnsToMakeSorted {
    static int minDeletionSize(String[] strs) {
        int K = strs[0].length();

        int answer = 0;
        for (int col = 0; col < K; col++) {
            for (int row = 1; row < strs.length; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] strs = {"cba","daf","ghi"};
        System.out.println(minDeletionSize(strs));
    }
}
