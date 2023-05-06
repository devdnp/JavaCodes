package leet_code._daily_prob.may23;
//06-May-2023
//#1498
import java.util.Arrays;

public class NumberofSubsequencesSatisfyGivenSumCondition {

    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        int target = 9;
        System.out.println(numSubseq(nums,target));
    }
    public static int numSubseq(int[] A, int target) {
        Arrays.sort(A);
        int res = 0, n = A.length, l = 0, r = n - 1, mod = (int)1e9 + 7,pows[] = new int[n];
        pows[0] = 1;
        for (int i = 1 ; i < n ; ++i) pows[i] = pows[i - 1] * 2 % mod;
        while (l <= r) {
            if (A[l] + A[r] > target) r--;
            else res = (res + pows[r - l++]) % mod;
        } return res;
    }
}