package leet_code._daily_prob.apr23;
//05Apr
//#2439
public class MinimizeMaximumOfArray {

    public static void main(String[] args) {
        int[] nums ={3,7,1,6};
        System.out.println(minimizeArrayValue(nums));
    }
    public static int minimizeArrayValue(int[] nums) {
        long ans = 0;
        long prefix = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefix += nums[i];
            final long prefixAvg = (long) Math.ceil(prefix / (double) (i + 1));
            ans = Math.max(ans, prefixAvg);
        }

        return (int) ans;
    }
}
