package leet_code.medium;
//#287
public class SmallestDivisorGivenThreshold {
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        System.out.println(findDuplicate(nums,threshold));
    }

    public static int findDuplicate(int[] nums, int threshold) {
        int l = 1, r = 1000000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (helper(mid, nums) > threshold) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    public static int helper(int mid, int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += (nums[i] + mid - 1) / mid;
        }
        return res;
    }
}