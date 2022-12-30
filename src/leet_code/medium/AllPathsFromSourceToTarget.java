package leet_code.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    static List<List<Integer>> ans;

    static  List<List<Integer>> allPathsSourceTarget(int[][] a) {
        ans = new ArrayList<>();
        for (int i = 0; i < a[0].length; i++) {
            List<Integer> curList = new ArrayList<>();
            curList.add(0);
            curList.add(a[0][i]);
            go(a, a[0][i], curList);
        }
        return ans;
    }

    static  void go(int[][] a, int x, List<Integer> curList) {
        if (x == a.length - 1) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < a[x].length; i++) {
            curList.add(a[x][i]);
            go(a, a[x][i], curList);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graphs = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graphs));
    }
}
