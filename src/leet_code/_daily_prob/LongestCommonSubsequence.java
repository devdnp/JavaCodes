package leet_code._daily_prob;

public class LongestCommonSubsequence {

        static int longestCommonSubsequence(String text1, String text2) {
            if(text1==null || text2==null || text1.length()==0 || text2.length()==0)
                return 0;
            int m = text1.length();
            int n = text2.length();
            int[][] result = new int[m+1][n+1];

            for(int i=1; i<=m; ++i){
                for(int j=1; j<=n; ++j){
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        result[i][j] = result[i-1][j-1]+1;
                    }else{
                        result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                    }
                }
            }
            return result[m][n];
        }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
