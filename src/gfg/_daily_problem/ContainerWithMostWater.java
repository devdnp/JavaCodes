package gfg._array._daily_problem;

import java.io.*;
import java.util.*;
import java.lang.*;


public class ContainerWithMostWater {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine()); // input size of array
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split("\\s+");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
            }
            Solve T = new Solve();
            long ans = T.maxArea(arr,n);
            System.out.println(ans);
        }
    }
}
class Solve{

    long maxArea(int a[], int len){
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
