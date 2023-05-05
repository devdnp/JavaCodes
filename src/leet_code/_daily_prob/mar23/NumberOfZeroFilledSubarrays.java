package leet_code._daily_prob.mar23;
//21-Mar-2023
//2348
public class NumberOfZeroFilledSubarrays {

    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        System.out.println(zeroFilledSubarray(nums));
    }
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int indexBeforeZero = -1;

        for (int i = 0; i < nums.length; ++i)
            if (nums[i] == 0)
                ans += i - indexBeforeZero;
            else
                indexBeforeZero = i;

        return ans;
    }
}