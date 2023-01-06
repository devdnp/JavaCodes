package leet_code._daily_prob;

public class MaxIcecreamBars {
    public static void main(String[] args) {
        int[] costs={1,3,2,4,1};
        int coins=7;
        System.out.println(maxIceCream(costs, coins));
    }
    static int maxIceCream(int[] costs, int coins) {

        int maxCost = 0;

        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        int[] numOfCosts = new int[maxCost + 1];

        for (int cost : costs) {
            numOfCosts[cost]++;
        }

        int iceCreamBars = 0;

        for (int cost = 1; cost <= maxCost; cost++) {
            if (numOfCosts[cost] == 0) {
                continue;
            }

            if (coins < cost) {
                break;
            }

            int count = Math.min(numOfCosts[cost], coins / cost);
            coins -= count * cost;
            iceCreamBars += count;
        }

        return iceCreamBars;
    }
}
