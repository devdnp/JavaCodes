package leet_code._daily_prob;
//149
import java.util.HashMap;
import java.util.Map;

public class MaxPointOnALine {
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(maxPoints(points));
    }
    static int maxPoints(int[][] points) {
        int max=0;
        for(int[] x:points)
        {
            Map<Double,Integer> map= new HashMap<>();
            for(int[] y:points){
                if(x==y)
                    continue;

                double slope=0;
                if(y[0]-x[0]==0)
                    slope=Double.POSITIVE_INFINITY;
                else
                    slope = (y[1]-x[1])/(double)(y[0]-x[0]);

                map.put(slope,map.getOrDefault(slope,0)+1);
                max=Math.max(max,map.get(slope));
            }
        }
        return max+1;
    }
}
