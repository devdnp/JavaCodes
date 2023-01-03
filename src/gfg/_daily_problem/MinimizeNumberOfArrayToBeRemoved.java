package gfg._daily_problem;

import java.io.*;
import java.util.*;

public class MinimizeNumberOfArrayToBeRemoved {
    public static void main(String args[]) throws IOException {
        int N = 6;
        int[] H = {9, 1, 2, 3, 1, 5};
        System.out.println(removeStudents(H,N));
    }
    static int removeStudents(int[] H, int N) {
        // code here
        ArrayList<Integer> dp=new ArrayList<>();
        for(int i=0;i<N;i++){
            int index=binarySearch(H[i],dp);
            if(index==dp.size()){
                dp.add(H[i]);
            }else{
                dp.set(index,H[i]);
            }
        }
        return N-dp.size();
    }
    static int binarySearch(int num,ArrayList<Integer> arr){
        int start=0;
        int end=arr.size()-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr.get(mid)>=num){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}