package gfg._daily_problem;

import java.util.PriorityQueue;

public class MinimizeTheSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 10};
        int n = arr.length;
        System.out.println(minimizeSum(n,arr));
    }
    static long minimizeSum(int n, int arr[]) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : arr) pq.offer(a);
        long ans=0,sum=0;
        while(pq.size()>1) {
            sum = pq.poll()+pq.poll();
            pq.offer((int)sum);
            ans+=sum;
        }
        return ans;
    }
}
