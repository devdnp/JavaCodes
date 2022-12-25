package leet_code._daily_prob;

import java.util.Arrays;

public class LongestSubsequenceLimitedSum {
    public static void main(String[] args) {
        int[] nums = {4,5,2,1};
        int [] queries = {3,10,21};
        System.out.println(Arrays.toString(answerQueries(nums, queries)));
    }

    static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int n = nums.length;
        int [] ans = new int [queries.length];

        for(int i=1; i<n; i++){
            nums[i] += nums[i-1];
        }

        for(int i=0; i<queries.length; i++){

            if(nums[n-1] <= queries[i]){
                ans[i] = n;
                continue;
            }

            for(int j=0; j<n; j++){
                if(nums[j] > queries[i]){
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;
    }
}
