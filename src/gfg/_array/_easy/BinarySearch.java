package gfg._array;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        System.out.println(binarysearch(arr, n, k));
    }
    static int binarysearch(int arr[], int n, int k) {
        Arrays.sort(arr);
        int s=0, l=n-1;

        while(l-s>1){
            int mid = (l + s) / 2;
            if (arr[mid] < k) {
                s = mid + 1;
            }
            else {
                l = mid;
            }
        }
        if(arr[s]==k) return s;
        else if(arr[l]==k) return l;
        else return -1;
    }
}
