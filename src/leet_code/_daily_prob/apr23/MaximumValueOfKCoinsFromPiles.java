package leet_code._daily_prob.apr23;
//15-Apr
//#2218

import java.util.ArrayList;
import java.util.List;

public class MaximumValueOfKCoinsFromPiles {

    public static void main(String[] args) {
        int[][] piles = {{100},{100},{100},{100},{100},{100},{1,1,1,1,1,1,700}};
        int k = 7;
        List<List<Integer>> pilesList = new ArrayList<>();

        for (int[] arr : piles) {
            List<Integer> subList = new ArrayList<>();
            for (int num : arr) {
                subList.add(num);
            }
            pilesList.add(subList);
        }
        System.out.println(maxValueOfCoins(pilesList,k));
    }
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // dp[i][k] := max value of picking k coins from piles[i:]
        dp = new Integer[piles.size()][k + 1];
        return maxValueOfCoins(piles, 0, k);
    }

    private static Integer[][] dp;

    private static int maxValueOfCoins(List<List<Integer>> piles, int i, int k) {
        if (i == piles.size() || k == 0)
            return 0;
        if (dp[i][k] != null)
            return dp[i][k];

        int ans = maxValueOfCoins(piles, i + 1, k); // Pick 0 coins from current pile
        int val = 0;                                // Coins picked from current pile

        // Try to pick 1, 2, ..., k coins from current pile
        for (int j = 0; j < Math.min(piles.get(i).size(), k); ++j) {
            val += piles.get(i).get(j);
            ans = Math.max(ans, val + maxValueOfCoins(piles, i + 1, k - j - 1));
        }

        return dp[i][k] = ans;
    }
}
