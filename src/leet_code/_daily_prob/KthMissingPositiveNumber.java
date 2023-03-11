package leet_code._daily_prob;
//Problem 1539
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {5,4,9,26,13};//{2,3,4,7,11};
        int k = 3;//5;
        System.out.println(findKthPositive(arr,k));
    }
    public static int findKthPositive(int[] arr, int k) {
        for(int i : arr){
            if(i <= k) k++; else break;
        }
        return k;
    }
}
