package d100._6day;

import java.util.HashMap;

public class PairWithGivenSum {
    static int getPairsCount(int[] arr, int n, int sum){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(sum-arr[i])){
                count += hm.get(sum-arr[i]);
            }
            if (hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(sum-arr[i])+1);
            }
            else
                hm.put(arr[i],1);
        }
        return count;
    }
    public static void main(String[] args)
    {
        int arr[] = { 1, 5, 7, -1, 5 };
        int n = arr.length;
        int sum = 6;
        System.out.print(getPairsCount(arr, n, sum));
    }
}
