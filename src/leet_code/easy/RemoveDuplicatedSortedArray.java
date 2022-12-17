package leet_code.easy;

import java.util.Arrays;

public class RemoveDuplicatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }
    static void removeDuplicates(int[] nums) {
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(i<nums.length-1 && nums[i]==nums[i+1]){
                continue;
            }
            nums[k]=nums[i];
            k++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
