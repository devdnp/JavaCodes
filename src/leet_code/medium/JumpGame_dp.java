package leet_code.medium;

import java.util.Arrays;

public class JumpGame_dp {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};//{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[nums.length-1] = true;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] == 0)
                dp[i] = false;
            else{
                if(nums[i] + i >= nums.length)
                    dp[i] = true;
                else{
                    for(int j = 1; j <= nums[i]; j++){
                        dp[i] = dp[i] || dp[i + j];
                        //tricky part: the next recurrance is aslo cover some elements for this value so that we can skip them.
                        j += nums[i + j];
                    }
                }
            }
        }

        return dp[0];

    }
}
