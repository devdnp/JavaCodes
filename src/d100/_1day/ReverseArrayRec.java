package d100._1day;

import java.util.Arrays;

public class ReverseArrayRec {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int start = 0, end = arr.length-1;
        reverseArrayRec(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }
    static void reverseArrayRec(int[] arr, int start, int end){
        if(start>=end)
            return;

            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            reverseArrayRec(arr, start+1, end-1);
    }
}
