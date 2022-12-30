package leet_code.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0, nums, result, new ArrayList<>());

        return result;
    }
    static void backtracking(int index, int[] nums, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for(int i=index;i<nums.length;i++) {
            list.add(nums[i]);
            backtracking(i+1, nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}
