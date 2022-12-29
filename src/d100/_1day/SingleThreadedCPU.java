package d100._1day;

import java.util.*;

public class SingleThreadedCPU {

    static int[] getOrder(int[][] tasks) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            list.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        Collections.sort(list, (a, b) -> (a[0] - b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]));
        List<Integer> res = new ArrayList<>();

        int time = 1;
        int m = tasks.length;
        int index = 0;
        while (res.size() < m) {
            // pq not empty
            if (!pq.isEmpty()) {
                int[] x = pq.poll();
                res.add(x[2]);
                time += x[1];
            } else if (index < m && list.get(index)[0] > time) {
                // pq empty
                time = list.get(index)[0];
            }

            int i = index;
            for (; index < m && list.get(index)[0] <= time; index++) {
                pq.offer(list.get(index));
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
        System.out.println(Arrays.toString(getOrder(tasks)));
    }
}
