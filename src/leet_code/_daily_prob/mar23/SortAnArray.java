package leet_code._daily_prob.mar23;

import java.util.Arrays;

//01-Mar
//#912
public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
    public static int[] sortArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int len = max - min;
        int[] arr = new int[len + 1];
        for (int num : nums) {
            arr[num - min]++;
        }
        int index = 0;
        for (int i = 0; i <= len; i++) {
            while (arr[i] > 0) {
                nums[index] = min;
                index++;
                arr[i]--;
            }
            min++;
        }
        return nums;
    }
}