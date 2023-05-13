package leet_code._daily_prob.may23;
//13-May-2023
//#2466
public class WaysToBuildGoodStrings {

    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(countGoodStrings(low,high,zero,one));
    }
    public static int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high+1];
        dp[0]=1;
        int ans=0;
        for(int i=1;i<=high;i++){
            dp[i] = ((i-zero>=0 ? dp[i-zero]:0)+(i-one>=0 ? dp[i-one]:0))%1000000007;
            if(i>=low){
                ans = (ans+dp[i])%1000000007;
            }
        }
        return ans;
    }
}