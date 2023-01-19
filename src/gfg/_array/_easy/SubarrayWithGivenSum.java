package gfg._array._easy;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum)
    {
        // Your code here
        int currentSum = arr[0], start = 0, end = 0;
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(-1));
        if(sum==0) return list1;
        ArrayList<Integer> list = new ArrayList<>();
        while (start < n && end < n) {
            if (currentSum < sum) {
                end++;
                if(end < n)
                    currentSum += arr[end];
            } else if (currentSum > sum) {
                currentSum -= arr[start];
                start++;
            } else {
                list.add(start+1);
                list.add(end+1);
                return list;
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9,10};
        int n = arr.length;
        int sum = 20;
        System.out.println(subarraySum(arr, n, sum));
    }
}
