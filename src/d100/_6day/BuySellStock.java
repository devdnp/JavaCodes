package d100._6day;

public class BuySellStock {
    static int maxProfit(int[] prices, int n){
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (buy>prices[i])
                buy=prices[i];
            else if(prices[i]-buy>maxProfit)
                maxProfit = prices[i]-buy;
        }
        return maxProfit;
    }

    public static void main(String args[])
    {
        int prices[] = { 7, 1, 5, 6, 4 };
        int max_profit = maxProfit(prices, prices.length);
        System.out.println(max_profit);
    }
}
