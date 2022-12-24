package leet_code._daily_prob;

public class DominoAndTromino {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTilings(n));
    }

    static int numTilings(int n) {
        int a = 0, b = 1, c = 1, c2, mod = 1000000007;
        while (--n > 0) {
            c2 = (c * 2 % mod + a) % mod;
            a = b;
            b = c;
            c = c2;
        }
        return c;
    }
}
