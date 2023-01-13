package gfg._daily_problem;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MinimumLaptopsRequired {
    public static void main(String[] args) throws IOException {
        int[] start = {1, 2, 3};
        int[] end = {4, 4, 6};
        int n = 3;
        System.out.println(minLaptops(n,start,end));
    }
    static int minLaptops(int n, int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0, j=0, count=0, max=0;
        while(i<n && j<n){
            if(start[i]<end[j]){
                i++;
                count++;
            }else{
                j++;
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
