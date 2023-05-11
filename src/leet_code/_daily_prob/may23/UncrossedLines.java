package leet_code._daily_prob.may23;
//11-May-2023
//#1035
public class UncrossedLines {

    public static void main(String[] args) {
        int[] nums1 = {2,5,1,2,5};
        int[] nums2 = {10,5,2,1,5,2};
        System.out.println(maxUncrossedLines(nums1,nums2));
    }
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length+1];

        for(int i = 1; i <= nums1.length; i++) {
            int[] dpRow = new int[nums2.length+1];
            for(int j = 1; j <= nums2.length; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dpRow[j] = dp[j-1] + 1;
                } else {
                    dpRow[j] = Math.max(dp[j], dpRow[j-1]);
                }
            }
            dp = dpRow;
        }

        return dp[nums2.length];
    }
}