package leet_code._daily_prob.apr23;
//24-Apr
//#1046

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max =new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone :stones){
            max.add(stone);
        }
        while(max.size()!=1){
            int x = max.remove();
            int y = max.remove();
            if(x==y) max.add(0);
            if(x!=y) max.add(x-y);
        }
        return max.peek();
    }
}