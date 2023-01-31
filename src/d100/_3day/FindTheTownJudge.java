package d100._3day;
//997
public class FindTheTownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        System.out.println(findJudge(n,trust));
    }
    public static int findJudge(int n, int[][] trust) {
        int arr[] = new int[n+1];
        for(int i=0;i<trust.length;i++){
            arr[trust[i][1]]++;
        }

        int judge =-1;
        boolean check=true;
        for(int i=0;i<=n;i++) if(arr[i]==n-1) judge=i;
        for(int i=0;i<trust.length;i++) if(trust[i][0] == judge) check=false;
        if(check) return judge;
        return -1;
    }
}
