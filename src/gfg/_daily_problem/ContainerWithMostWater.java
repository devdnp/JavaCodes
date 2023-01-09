package gfg._array._daily_problem;

import java.io.*;
import java.lang.*;


public class ContainerWithMostWater {
    public static void main (String[] args) throws IOException{
        int[] a = {1,5,4,3};
        int len = a.length;
        System.out.println(maxArea(a, len));
    }
    static long maxArea(int a[], int len){
        // Code Here
        int res=0,temp=0;
        int i=0,j=len-1;
        while(i<j){
            if(a[i]<=a[j]){
                temp=a[i]*(j-i);
                i++;
            }
            else{
                temp = a[j]*(j-i);
                j--;
            }
            res = temp>=res?temp:res;
        }
        return res;

    }

}
