package gfg._daily_problem;

public class CountEvenLength {
    public static final long mod = 1000000007;
    public static int  compute_value(int n)
    {
        // code here
        int fact_n=1;
        for(int i=1;i<=n;i++) fact_n = multi(fact_n,i);

        int fact_nr=fact_n;
        int fact_r=1;
        int ans=0;
        for(int r=0;r<=n;r++) {
            int denominator = multi(fact_nr,fact_r);
            int val = divide(fact_n,denominator);
            ans = add(ans,multi(val,val));

            fact_r = multi(fact_r,r+1);
            if(n!=r) fact_nr = divide(fact_nr,n-r);
        }

        return ans;
    }

    public static long power(long a,long b) {
        if(b==0) return 1;
        long p = power(a,b/2);
        p = multi(p,p);
        if(b%2==1) p = multi(p,a);
        return p;
    }

    public static int add(long a,long b) {
        return (int)(((a%mod)+(b%mod))%mod);
    }

    public static int multi(long a,long b) {
        return (int)(((a%mod)*(b%mod))%mod);
    }

    // {1/b}%mod => {b^(-1)}%mod => power(b,mod-2);
    public static int divide(long a,long b) {
        return multi(a,power(b,mod-2));
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(compute_value(n));
    }
}
