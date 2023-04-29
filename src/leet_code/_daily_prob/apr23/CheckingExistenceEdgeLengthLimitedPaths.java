package leet_code._daily_prob.apr23;
//29-Apr
//#1697

import java.util.Arrays;
import java.util.Comparator;

public class CheckingExistenceEdgeLengthLimitedPaths {

    public static void main(String[] args) {
        int n = 3;
        int[][] edgeList = {{0,1,2},{1,2,4},{2,0,8},{1,0,16}};
        int[][] queries = {{0,1,2},{0,2,5}};
        System.out.println(Arrays.toString(distanceLimitedPathsExist(n,edgeList,queries)));
    }
    private static int[] parent;
    private static int[] rank;
    private static int[] weight;
    public static boolean[] distanceLimitedPathsExist(int length, int[][] adjList, int[][] queries) {
        parent = new int[length];
        rank = new int[length];
        weight = new int[length];
        for (int i = 0; i < length ; i++) parent[i] = i;

        // Sorting edges in the adjacency list by distance
        Arrays.sort(adjList, Comparator.comparingInt(a -> a[2]));
        // Group nodes into connected components using union-find algorithm
        for (int[] edge : adjList) unionByRank(edge[0], edge[1], edge[2]);

        // Initializing answer array
        boolean[] answer = new boolean[queries.length];
        // Check if there is a path between two nodes with distance less than the given limit for each query
        for (int i = 0 ; i < queries.length; i++)
            answer[i] = isConnectedAndWithinLimit(queries[i][0], queries[i][1], queries[i][2]);

        return answer;
    }

    // Check if there is a path between two nodes with distance less than the given limit
    public static boolean isConnectedAndWithinLimit(int p, int q, int limit) {
        return find(p, limit) == find(q, limit);
    }

    // Find the root of the connected component for a node with distance less than the given limit
    private static int find (int x, int limit) {
        while (x != parent[x]) {
            // If the weight of the edge is greater than or equal to the given limit, break out of the loop
            if (weight[x] >= limit) {
                break;
            }
            x = parent[x];
        }
        return x;
    }

    // Union two nodes into the same connected component with the given limit as the weight of the edge
    private static void unionByRank (int x, int y, int limit) {
        // Find the root of the connected component for each node
        int x_ref = find (x, Integer.MAX_VALUE);
        int y_ref = find (y, Integer.MAX_VALUE);
        // If the nodes are already in the same connected component, return
        if (x_ref == y_ref) {
            return;
        }
        // If the rank of the root of x is less than the rank of the root of y, make y the parent of x
        if (rank[x_ref] < rank[y_ref]) {
            parent[x_ref] = y_ref;
            weight [x_ref] = limit;;
        } else {
            // Otherwise, make x the parent of y
            parent[y_ref] = x_ref;
            weight[y_ref] = limit;
            // If the ranks of the roots are equal, increment the rank of the root of x
            if (rank[x_ref] == rank[y_ref]) {
                rank[x_ref]++;
            }
        }
    }
}