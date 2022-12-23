package d100._9day;

public class BestTimeToBuySellStocks {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int ob = -prices[0];
        int os = 0;
        int oc = 0;

        for(int i=1;i<prices.length;i++){
            int nb = Math.max(ob,oc-prices[i]);
            int ns = Math.max(os,ob+prices[i]);
            int nc = Math.max(oc,os);

            ob=nb;
            os=ns;
            oc=nc;
        }
        return os;
    }
}
