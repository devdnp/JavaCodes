package leet_code.medium;
//1519
import java.util.*;

public class NodesInSubtreeWithSameLabel {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        int n = 7;
        String labels = "abaedcd";
        System.out.println(Arrays.toString(countSubTrees(n,edges,labels)));
    }
    static int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int[] ans = new int[n];
        char[] label = labels.toCharArray();
        dfs(0, -1, adj, label, ans);
        return ans;
    }
    public static int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj,
                     char[] labels, int[] ans) {
        int[] nodeCounts = new int[26];
        nodeCounts[labels[node] - 'a'] = 1;

        if (!adj.containsKey(node))
            return nodeCounts;
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            int[] childCounts = dfs(child, node, adj, labels, ans);
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }

        ans[node] = nodeCounts[labels[node] - 'a'];
        return nodeCounts;
    }
}
