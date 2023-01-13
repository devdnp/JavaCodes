package gfg._daily_problem;

import java.util.HashSet;

public class CountLuckyPermutations {
    public static void main(String[] args) {
        int N = 3, M = 2;
        int[] arr = {1, 2, 3};
        int[][] graph = {{3, 1}, {1, 2}};
        System.out.println(luckyPermutations(N,M,arr,graph));
    }

    static long luckyPermutations(int N, int M, int arr[], int[][] graph) {
        // Code here
        HashSet<Integer>[] set = new HashSet[N+1];

        for(int i=0;i<=N;i++)
            set[i] = new HashSet<>();

        for(int[] g : graph) {
            set[g[0]].add(g[1]);
            set[g[1]].add(g[0]);
        }
        return fun(set, arr, 0, -1, 0, new Long[N][N+2][1<<N]);
    }

    static long fun(HashSet<Integer>[] graph,int[] a,int index,int cur,int visit,Long[][][] dp) {
        if(index>=a.length) return 1;

        if(dp[index][cur+1][visit]!=null) return dp[index][cur+1][visit];
        long ans=0;
        for(int i=0;i<a.length;i++) {
            if((visit&(1<<i))==0) {
                //here visit[i]=1;
                if(cur==-1) {
                    ans+=fun(graph,a,index+1,a[i],visit+(1<<i),dp);
                } else {
                    if(graph[cur].contains(a[i])) {
                        ans+=fun(graph,a,index+1,a[i],visit+(1<<i),dp);
                    }
                }
                //and here visit[i]=0;
            }
        }
        return dp[index][cur+1][visit]=ans;
    }
}
