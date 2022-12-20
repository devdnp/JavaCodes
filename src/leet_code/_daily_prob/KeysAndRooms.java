package leet_code._daily_prob;

import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    static boolean[] visited;
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return false;
        int size = rooms.size();
        visited = new boolean[size];
        List<Integer> room0 = rooms.get(0);
        visited[0] = true;
        for(Integer next : room0){
            dfs(rooms, 0);
        }
        for(boolean v : visited)
            if(!v) return false;
        return true;
    }
    private static void dfs(List<List<Integer>> rooms, int curRoom){
        visited[curRoom] = true;
        List<Integer> nexts = rooms.get(curRoom);
        for(Integer next: nexts){
            if(!visited[next])
                dfs(rooms, next);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1,3),
                Arrays.asList(3,0,1),
                Arrays.asList(2),Arrays.asList(0));
        System.out.println(canVisitAllRooms(rooms));
    }
}
