package leet_code.hard;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPathWithDiffAdjChars {
    static int longestPath(int[] parent, String s) {
        int n = parent.length;
        int[] count = new int[n];

        for (int node = 1; node < n; node++) {
            count[parent[node]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int l_path = 1;
        int[][] l_chains = new int[n][2];

        for (int node = 1; node < n; node++) {

            if (count[node] == 0) {
                l_chains[node][0] = 1;
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            int par = parent[curr];
            int longestFromCurr = l_chains[curr][0];

            if (s.charAt(curr) != s.charAt(par)) {

                if (longestFromCurr > l_chains[par][0]) {
                    l_chains[par][1] = l_chains[par][0];
                    l_chains[par][0] = longestFromCurr;
                } else if (longestFromCurr > l_chains[par][1]) {
                    l_chains[par][1] = longestFromCurr;
                }
            }

            l_path = Math.max(l_path, l_chains[par][0] + l_chains[par][1] + 1);
            count[par]--;

            if (count[par] == 0 && par != 0) {
                l_chains[par][0]++;
                q.offer(par);
            }
        }

        return l_path;
    }

    public static void main(String[] args) {
        int[] parents = {-1,0,0,0};
        String s = "aabc";
        System.out.println(longestPath(parents,s));
    }
}
