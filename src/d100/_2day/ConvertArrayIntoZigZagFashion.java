package d100._2day;

import java.util.Arrays;

public class ConvertArrayIntoZigZagFashion {
    public static void main(String[] args) {
        int[] a={1, 4, 3, 2};
        int n=a.length;
        System.out.println(Arrays.toString(zigZag(a,n)));
    }
    static int[] zigZag(int a[], int n){
        // Code your solution here.
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                // i is even: arr[i] < arr[i + 1]
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            } else {
                // i is odd: arr[i] > arr[i + 1]
                if (a[i] < a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        return a;
    }
}
