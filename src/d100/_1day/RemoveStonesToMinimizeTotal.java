package d100._1day;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue(Comparator.reverseOrder());

        int sum = 0;
        for (int pile : piles) {
            heap.offer(pile);
            sum+= pile;
        }

        int removed = 0;
        while (k != 0) {

            int node = heap.poll();
            removed += node/2;
            heap.offer(node - node/2);


            k--;
        }
        return sum - removed;
    }
    public static void main(String[] args) {
        int[] piles = {4,3,6,7};
        int k = 3;
        System.out.println(minStoneSum(piles,k));
    }
}