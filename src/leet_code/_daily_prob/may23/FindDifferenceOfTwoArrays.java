package leet_code._daily_prob.may23;
//03-May-2023
//#2215
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(findDifference(nums1,nums2));
    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> diff1 = getDifference(nums1, nums2);
        List<Integer> diff2 = getDifference(nums2, nums1);
        return Arrays.asList(diff1, diff2);
    }

    private static List<Integer> getDifference(int[] nums1, int[] nums2) {
        List<Integer> difference = new ArrayList<>();
        boolean[] seen = new boolean[2001];

        for (int i : nums2) {
            seen[i + 1000] = true;
        }

        for (int i : nums1) {
            if (!seen[i + 1000]) {
                seen[i + 1000] = true;
                difference.add(i);
            }
        }
        return difference;
    }
}