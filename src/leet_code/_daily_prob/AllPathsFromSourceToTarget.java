package leet_code._daily_prob;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        deepSearch(graph, 0, path, res);

        return res;
    }

    static void deepSearch(int[][] graph, int index, List<Integer> path, List<List<Integer>> res) {
        if (index + 1 == graph.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int node : graph[index]) {
            path.add(node);
            deepSearch(graph, node, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
}
