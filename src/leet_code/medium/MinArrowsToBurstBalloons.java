package leet_code.medium;

import java.util.Arrays;
//452-NomallyOptimized
public class MinArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(points));
    }
    static int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        // integer overflow ,don't use a[1] -b[1]
        Arrays.sort(points, (a, b)->Integer.compare(a[1],b[1]));

        int res= 1;
        int end =points[0][1];

        for(int[] point : points){

            if(point[0]>end){
                res++;
                end= point[1];
            }
        }
        return res;
    }
}
