package leet_code._daily_prob;

import java.util.*;

//1345
public class JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<Integer> list = map.get(arr[i]);
            if(list == null) map.put(arr[i], list = new ArrayList<>());
            list.add(i);
        }
        int[] visited = new int[n];
        Deque<Integer> forward = new LinkedList<>(), backward = new LinkedList<>();
        visited[0] = 1;
        forward.add(0);
        visited[n - 1] = 2;
        backward.add(n - 1);
        for(int res = 1, dir = 1; ; res++) {
            if(forward.size() > backward.size()) {
                Deque<Integer> temp = forward; forward = backward; backward = temp;
                dir = 3 - dir;
            }
            for(int size = forward.size(); size-- > 0; ) {
                int i = forward.poll();
                List<Integer> list = map.get(arr[i]);
                if(i - 1 >= 0) list.add(i - 1);
                if(i + 1 < n) list.add(i + 1);
                for(int j: list) {
                    if(visited[j] == 0) {
                        visited[j] = dir;
                        forward.add(j);
                    } else if(visited[j] != dir) return res;
                }
                list.clear();
            }
        }
    }
}
