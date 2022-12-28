package d100._8day;

import java.util.*;

public class PathExistenceInGraph {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0;
        int destination = 2;
        System.out.println(validPath(n, edges, source, destination));
    }

    static boolean validPath(int n, int[][] edges, int source, int destination) {
        if( source == destination ) return true;
        Map<Integer, List<Integer>> fromTo = new HashMap<>();

        for( int[] e : edges ){

            fromTo.putIfAbsent(e[0], new ArrayList<>());
            fromTo.putIfAbsent(e[1], new ArrayList<>());
            fromTo.get(e[0]).add(e[1]);
            fromTo.get(e[1]).add(e[0]);

        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        while( !q.isEmpty() ){
            int size = q.size();
            while(size--> 0){
                int curr = q.poll();
                for( int neighbor : fromTo.getOrDefault(curr, new ArrayList<>()) ){
                    if( neighbor == destination ) return true;
                    q.offer(neighbor);
                }
                fromTo.remove(curr);
            }
        }
        return false;
    }
}
