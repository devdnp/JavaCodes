package leet_code._daily_prob;
//974
public class SubarrayWithSumEqualToK {
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums,k));
    }
    static int subarraysDivByK(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
        int[] modGroups = new int[k];
        modGroups[0] = 1;
        int ans = 0;
        for (int sum : prefixSum) {
            int mod = sum%k;
            if (mod < 0) mod += k;
            ans += modGroups[mod];
            modGroups[mod]++;
        }
        return ans;
    }
}
