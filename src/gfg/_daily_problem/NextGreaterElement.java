package gfg._daily_problem;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        long[] ans = new long[n];
        Stack<Long> stack = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(stack.size()>0 && stack.peek()<=arr[i]) {
                stack.pop();
            }
            if(stack.size()==0) {
                ans[i]=-1;
            } else {
                ans[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {6,8,0,1,3};
        int n = arr.length;
        System.out.println(Arrays.toString(nextLargerElement(arr,n)));
    }
}
