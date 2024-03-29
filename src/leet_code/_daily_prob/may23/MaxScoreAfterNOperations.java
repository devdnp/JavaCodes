package leet_code._daily_prob.may23;
//14-May-2023
//#1799
public class MaxScoreAfterNOperations {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(maxScore(nums));
    }
    public static int maxScore(int[] nums) {
        int n = nums.length;
        int[][] gcd = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                gcd[i][j] = gcd(nums[i],nums[j]);
            }
        }

        int[] dp = new int[1<<n];
        for(int i = 0; i < (1<<n); i++){
            int cnt = Integer.bitCount(i);
            if(cnt%2!=0) continue;
            for(int x = 0; x < n; x++){
                if((i&(1<<x))>0) continue;
                for(int y = x+1; y < n; y++){
                    if((i&(1<<y))>0) continue;
                    dp[i|(1<<x)|(1<<y)] = Math.max(dp[i]+gcd[x][y]*(cnt/2+1),dp[i|(1<<x)|(1<<y)]);
                }
            }
        }
        return dp[(1<<n)-1];
    }

    private static int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}