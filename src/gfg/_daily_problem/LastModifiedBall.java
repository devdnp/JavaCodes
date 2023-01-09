package gfg._daily_problem;

public class LastModifiedBall {
    public static void main(String[] args) {
        int[] a ={3, 1, 4, 5};
        int n = a.length;
        System.out.println(solve(n,a));
    }
    static int solve(int N, int[] A) {
        // code here
        for(int i=N-1;i>=0;i--)
            if(A[i]<9)
                return i+1;
        return 0;
    }
}
