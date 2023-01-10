package gfg._array._basic;

import java.util.Arrays;

public class ConvertArrayIntoZigZagFashion {
    public static void main(String[] args) {
        int[] a={4, 3, 7, 8, 6, 2, 1};
        int n=a.length;
        System.out.println(Arrays.toString(zigZag(a,n)));
    }
    static int[] zigZag(int a[], int n){
        // Code your solution here.
        for (int i = 0; i < a.length - 1; i++) {
            if ((i % 2 == 0 && a[i] > a[i + 1]) || (i % 2 == 1 && a[i] < a[i + 1])) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        return a;
    }
}
