package leet_code._daily_prob;
//787
import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        while (k-- >= 0) {
            if (isExistsRoute(flights, dp)) {
                break;
            }
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }

    private static boolean isExistsRoute(int[][] flights, int[] dp) {
        int[] temp = Arrays.copyOf(dp, dp.length);
        boolean result = true;
        for (int[] flight : flights) {
            int src = flight[0];
            int dst = flight[1];
            int cost = flight[2];
            if (temp[src] < Integer.MAX_VALUE && dp[dst] > dp[src] + cost) {
                dp[dst] = temp[src] + cost;
                result = false;
            }
        }
        return result;
    }
}
