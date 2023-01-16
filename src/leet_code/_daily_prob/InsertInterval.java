package leet_code._daily_prob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> inter = new ArrayList<>();

        for(int[] curr : intervals){
            if(curr[0] > newInterval[1]){
                inter.add(newInterval);
                newInterval = curr;
            }
            else if(curr[1] < newInterval[0]){
                inter.add(curr);
            }
            else{
                int st = Math.min(curr[0],newInterval[0]);
                int end = Math.max(curr[1],newInterval[1]);
                newInterval[0] = st;
                newInterval[1] = end;
            }
        }
        inter.add(newInterval);

        int[][] retu = new int[inter.size()][];
        for(int i=0;i<inter.size();i++){
            retu[i] = inter.get(i);
        }
        return retu;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        System.out.println(Arrays.deepToString(insert(intervals,newInterval)));
    }
}
