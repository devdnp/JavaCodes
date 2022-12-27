package leet_code._daily_prob;

import java.util.Arrays;

public class FullCapacityRocks {
    public static void main(String[] args) {
        int[] capacity = {10,2,2};
        int[] rocks = {2,2,0};
        int additionalRocks = 100;
        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }

    static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        long total = 0;
        int length = capacity.length;
        for(int i = 0; i < length; i++){
            capacity[i] -= rocks[i];
            total += capacity[i];
        }
        if(total > additionalRocks){
            Arrays.sort(capacity);
            for(int i = 0; i < length; i++){
                if(additionalRocks < capacity[i]){
                    return i;
                }
                additionalRocks -= capacity[i];
            }
        }
        return length;
    }
}
