package leet_code.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
        static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> complement = new HashMap<>();
            for(int i=0; i<nums.length; i++){
                Integer complementIndex = complement.get(nums[i]);
                if(complementIndex!=null){
                    return new int[]{i, complementIndex};
                }
                complement.put(target-nums[i],i);
            }
            return nums;
        }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
