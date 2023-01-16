package leet_code._daily_prob;

import java.util.Arrays;

public class NumberOfGoodPaths {

    static int[] parents, count, vals;
    static int res;

    public static void main(String[] args) {
        int[] vals = {1,3,2,1,3};
        int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
        System.out.println(numberOfGoodPaths(vals,edges));
    }

    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        NumberOfGoodPaths.vals = vals;
        Arrays.sort(edges, (a, b) -> Math.max(vals[a[0]], vals[a[1]]) - Math.max(vals[b[0]], vals[b[1]]));
        res = vals.length;

        parents = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            parents[i] = i;
        }
        count = new int[vals.length];
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return res;
    }

    private static boolean union(int a, int b) {
        int pa = parent(a);
        int pb = parent(b);
        if (pa == pb) {
            return false;
        }

        if (vals[pa] == vals[pb]) {
            res += (count[pa] + 1) * (count[pb] + 1);
            count[pa] += count[pb] + 1;
            parents[pb] = pa;
        } else if (vals[pa] > vals[pb]) {
            parents[pb] = pa;
        } else {
            parents[pa] = pb;
        }

        return true;
    }

    private static int parent(int a) {
        int p;
        if ((p = parents[a]) != a) {
            p = parents[a] = parent(p);
        }
        return p;
    }
}
