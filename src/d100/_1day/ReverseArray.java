package d100._1day;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int start = 0, end = arr.length-1;
        reverseArray(arr, start, end);
    }
    static void reverseArray(int[] arr, int start, int end){
        int temp = 0;
        while(start<=end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
            System.out.println(Arrays.toString(arr));

    }
}
