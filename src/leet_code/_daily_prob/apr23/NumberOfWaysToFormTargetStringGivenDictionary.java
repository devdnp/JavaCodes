package leet_code._daily_prob.apr23;
//16-Apr
//#1639
public class NumberOfWaysToFormTargetStringGivenDictionary {

    public static void main(String[] args) {
        String[] words = {"acca","bbbb","caca"};
        String target = "aba";
        System.out.println(numWays(words,target));
    }
    public static int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = target.length();
        int mod = 1000000007;
        int[] dp = new int[m+1];
        dp[0] = 1;

        int[][] count = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >= 0; j--) {
                dp[j+1] += (int)((long)dp[j] * count[i][target.charAt(j) - 'a'] % mod);
                dp[j+1] %= mod;
            }
        }

        return dp[m];
    }
}