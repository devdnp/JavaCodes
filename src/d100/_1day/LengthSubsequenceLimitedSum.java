package d100._1day;

import java.util.Arrays;

public class LengthSubsequenceLimitedSum {
    public static void main(String[] args) {
        int[] nums = {4,5,2,1};
        int [] queries = {3,10,21};
        System.out.println(Arrays.toString(answerQueries(nums, queries)));
    }
    static int[] answerQueries(int[] nums, int[] queries){
        int[] ans = new int[queries.length];

        Arrays.sort(nums);

        for (int i = 0; i < queries.length; ++i)
            ans[i] = numOfElementsLessThan(nums, queries[i]);

        return ans;
    }

    private static int numOfElementsLessThan(int[] nums, int query) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum > query)
                return i;
        }
        return nums.length;
    }
}
