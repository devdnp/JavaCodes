package leet_code._daily_prob;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        for(int i : arr){
            if(i <= k) k++; else break;
        }
        return k;
    }
}
