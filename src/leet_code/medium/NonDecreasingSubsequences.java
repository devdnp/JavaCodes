package leet_code.medium;
//491
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {

    public static void main(String[] args) {
        int[] nums = {4,4,3,2,1};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> sequence = new ArrayList<Integer>();
        backtrack(nums, 0, sequence, result);
        return new ArrayList(result);
    }

    private static void backtrack(int[] nums, int index, List<Integer> sequence,
                           Set<List<Integer>> result) {
        // if all elements checked
        if (index == nums.length) {
            if (sequence.size() >= 2) {
                result.add(new ArrayList<>(sequence));
            }
            return;
        }

        if (sequence.isEmpty() || sequence.get(sequence.size() - 1) <= nums[index]) {
            sequence.add(nums[index]);
            // recursive call
            backtrack(nums, index + 1, sequence, result);
            // remove nums[index] from end
            sequence.remove(sequence.size() - 1);
        }
        backtrack(nums, index + 1, sequence, result);
    }
}
