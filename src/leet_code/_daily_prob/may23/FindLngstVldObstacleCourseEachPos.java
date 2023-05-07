package leet_code._daily_prob.may23;
//07-May-2023
//#1964
import java.util.Arrays;

public class FindLngstVldObstacleCourseEachPos {

    public static void main(String[] args) {
        int obstacles[] = {1,2,3,2};
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(obstacles)));
    }
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] largestObstacleLength = new int[n];
        int[] minHeightStack = new int[n];
        int j = -1;

        for(int i=0;i<n;i++){
            if(j==-1 || (obstacles[i] >= minHeightStack[j])){
                minHeightStack[++j] = obstacles[i];
                largestObstacleLength[i] = j+1;
            }else{
                int left = 0, right = j;
                while(left<right){
                    int mid = left+(right-left)/2;
                    if(minHeightStack[mid]<=obstacles[i]){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }
                minHeightStack[right] = obstacles[i];
                largestObstacleLength[i] = right+1;
            }
        }
        return largestObstacleLength;
    }
}