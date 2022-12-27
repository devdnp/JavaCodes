package d100._1day;

import java.util.Arrays;

public class FullCapacityRocks {

    public static void main(String[] args) {
        int[] capacity = {2,3,4,5};
        int[] rocks = {1,2,4,4};
        int additionalRocks = 2;
        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }

    static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[]diff = new int[capacity.length];
        long cnt = 0;
        int resCnt = 0;

        for(int i=0 ;i<capacity.length;i++)
        {
            int diffCnt = capacity[i] - rocks[i];

            diff[i] = diffCnt;
            cnt+=(long)diffCnt;
        }

        if((long)additionalRocks > cnt)
        {
            return capacity.length;
        }

        Arrays.sort(diff);

        for(int a : diff)
        {
            if(a == 0)
            {
                resCnt+=1;
                continue;
            }

            if(additionalRocks>=a)
            {
                resCnt+=1;
                additionalRocks-= a;
            }
            else
            {
                return resCnt;
            }        }

        return resCnt;
    }
}
