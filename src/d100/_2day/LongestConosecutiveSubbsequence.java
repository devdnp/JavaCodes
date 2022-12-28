package d100._2day;

import java.util.HashSet;

public class LongestConosecutiveSubbsequence {
    public static void main(String[] args) {
        int[] arr= {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};//{1, 9, 3, 10, 4, 20, 2};
        System.out.println(longestConsecSubseq(arr, arr.length));
    }
    static int longestConsecSubseq(int[] arr, int n){
        int count=0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            hs.add(arr[i]);
        }
        for (int i = 0; i < n; ++i) {

            if(!hs.contains(arr[i]-1)){
                int j = arr[i];
                while(hs.contains(j)){
                    hs.remove(j);
                    j++;
                }

                if(count<j-arr[i])
                    count = j-arr[i];
            }
        }
        return count;
    }
}
