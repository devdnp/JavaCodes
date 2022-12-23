package leet_code._daily_prob;

public class PossibleBipartition {
    public static void main(String[] args) {
        int n = 5;
        int[][] dislikes = {{1, 2},{2, 3},{3, 4},{4, 5},{1, 5}};
        System.out.println(possibleBipartitionProcess(n, dislikes));
    }

    static boolean possibleBipartitionProcess(int n, int[][] dislikes) {
        int[] group = new int[n+1];
        for (int i = 1; i <= n; )  group[i] = i++;
        int a, ga, b, gb;

        int i = dislikes.length;
        while (--i >= 0) {
            a = dislikes[i][0];
            ga = group[a];
            b = dislikes[i][1];
            gb = group[b];

            if (ga == a && gb == b) {
                group[a] = b;
                group[b] = a;
            } else if (ga == a && gb != b) {
                // let a go to group that all hate b;
                group[a] = group[gb];
            } else if (gb ==b && ga != a) {
                group[b] = group[ga];
            } else if (gb == ga) {
                return false;
            }
        }
        return true;
    }
}
