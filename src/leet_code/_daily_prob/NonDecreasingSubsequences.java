package leet_code._daily_prob;
//491
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    private static void backtrack(int[] nums, int start) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if ((path.size() >= 1 && nums[i] < path.get(path.size() - 1)) || set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
