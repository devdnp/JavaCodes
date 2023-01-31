package leet_code.easy;
//997
public class FindTheTownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3},{3,1}};
        System.out.println(findJudge(n,trust));
    }
    public static int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1) return 1;

        int[] check = new int[n+1];
        for(int[] x : trust){
            check[x[0]]--;
            check[x[1]]++;
        }

        for(int i=0; i<check.length; i++){
            if(check[i]==n-1) return i;
        }

        return -1;
    }
}
