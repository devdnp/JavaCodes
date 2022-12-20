package d100._8day;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KeysAndRooms {
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return false;
        int size = rooms.size();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size];
        queue.addAll(rooms.get(0));
        visited[0] = true;
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i = 0; i < s; i++){
                int cur = queue.poll();
                visited[cur] = true;
                List<Integer> temp = rooms.get(cur);
                for(Integer t : temp){
                    if(!visited[t])
                        queue.offer(t);
                }
            }
        }
        for(Boolean v : visited){
            if(!v) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1,3),
                Arrays.asList(3,0,1),
                Arrays.asList(2),Arrays.asList(0));
        System.out.println(canVisitAllRooms(rooms));
    }
}
