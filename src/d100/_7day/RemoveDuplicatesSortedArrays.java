package d100._7day;

import java.util.Arrays;

public class RemoveDuplicatesSortedArrays {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }
    static void removeDuplicates(int[] nums) {
        int uniqueCount = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i];
                uniqueCount += 1;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
