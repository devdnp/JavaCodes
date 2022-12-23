package leet_code._daily_prob;

public class PathExistenceInGraph {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0;
        int destination = 2;
        System.out.println(validPath(n, edges, source, destination));
    }

    static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean path[] = new boolean[n];
        boolean processed = true;
        path[source] = true;
        while(!path[destination] && processed)
        {
            processed = false;
            for(int[] edge: edges)
            {
                int a = edge[0];
                int b = edge[1];
                if(path[a] ^ path[b]) // if both true - visited
                {
                    processed = true;
                    path[a] = true;
                    path[b] = true;
                }
            }
        }
        return path[destination];
    }
}
