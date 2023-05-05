package leet_code._daily_prob.mar23;
//22-Mar-2023
//#2492
public class MinScoreOfPathBwTwoCities {

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        System.out.println(minScore(n,roads));
    }
    static int[] par,rank,values;

    public static int find(int a){
        if(par[a] == a) return a;
        return par[a] = find(par[a]);
    }

    public static void union(int a,int b,int val){
        int la = find(a),lb = find(b);

        values[la] = Math.min(val,Math.min(values[la],values[lb]));
        values[lb] = Math.min(val,Math.min(values[la],values[lb]));

        if(la != lb){
            if(rank[la] > rank[lb]){
                par[lb] = la;
                rank[la] += rank[lb];

            }else{
                par[la] = par[lb];
                rank[lb] += rank[la];

            }
        }
    }
    public static int minScore(int n, int[][] roads) {
        par = new int[n];
        rank = new int[n];
        values = new int[n];

        for(int i = 0;i < n;i++){
            par[i] = i;
            rank[i] = 1;
            values[i] = Integer.MAX_VALUE;
        }

        for(int[] road : roads){
            int u = road[0] - 1,v = road[1] - 1,wt = road[2];

            union(u,v,wt);
        }
        return values[find(0)];
    }
}
