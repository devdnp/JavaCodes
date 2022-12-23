package d100._9day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumofDistancesInTree {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        System.out.println(Arrays.toString(sumOfDistancesInTree(n, edges)));
    }

    static int[] sumOfDistancesInTree(int n, int[][] edges) {
        Set<Integer>[] tree = new Set[n];
        for (int i = 0; i < n; i ++) {
            tree[i] = new HashSet();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        int[] result = new int[n];
        int[] count = new int[n];

        post(tree, count, result, 0, -1);
        pre(tree, count, result, 0, -1);

        return result;
    }

    private static void post(Set<Integer>[] tree, int[] count, int[] result, int root, int prev) {
        for (int child : tree[root]) {
            if (child == prev) {
                continue;
            }
            post(tree, count, result, child, root);
            count[root] += count[child];
            result[root] += result[child] + count[child];
        }
        count[root] ++;
    }

    private static void pre(Set<Integer>[] tree, int[] count, int[] result, int root, int prev) {
        for (int child : tree[root]) {
            if (child == prev) {
                continue;
            }
            result[child] = result[root] - count[child] + (count.length - count[child]);
            pre(tree, count, result, child, root);
        }
    }
}
