package leet_code._daily_prob;
//997
public class FindTheTownJudge {
    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1,2}};
        System.out.println(findJudge(n,trust));
    }
    public static int findJudge(int n, int[][] trust) {

        int[] arr = new int[n];

        for(int i = 0; i < trust.length; i++) {
            arr[trust[i][1] - 1]++;
        }

        int max = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[max] < arr[i]) {
                max = i;
            }
        }

        for(int i = 0; i < trust.length; i++) {
            if(max + 1 == trust[i][0]) {
                return -1;
            }
        }
        if(arr[max] == n - 1) {
            return max + 1;
        } else {
            return -1;
        }
    }
}
