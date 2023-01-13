package d100._2day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPathWithDiffAdjChars {
    private static int longestPath = 1;

    static int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i = 1; i < n; i++) {
            children.computeIfAbsent(parent[i], value -> new ArrayList<Integer>()).add(i);
        }

        dfs(0, children, s);

        return longestPath;
    }

    static int dfs(int currentNode, Map<Integer, List<Integer>> children, String s) {
        if (!children.containsKey(currentNode)) {
            return 1;
        }

        int longestChain = 0, secondLongestChain = 0;
        for (int child : children.get(currentNode)) {
            int longestFromChild = dfs(child, children, s);
            if (s.charAt(currentNode) == s.charAt(child)) {
                continue;
            }

            if (longestFromChild > longestChain) {
                secondLongestChain = longestChain;
                longestChain = longestFromChild;
            } else if (longestFromChild > secondLongestChain) {
                secondLongestChain = longestFromChild;
            }
        }

        longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }

    public static void main(String[] args) {
        int[] parents = {-1,0,0,1,1,2};
        String s = "abacbe";
        System.out.println(longestPath(parents,s));
    }
}
