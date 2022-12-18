package d100._7day;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArray {
    static boolean subarrayZeroSum(int[] arr){
        Set<Integer> set = new HashSet<>();
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];

            if(arr[i]==0 || sum==0 || set.contains(sum))
                return true;
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        System.out.println(subarrayZeroSum(arr));
    }
}
