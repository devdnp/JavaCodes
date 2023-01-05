package d100._2day;
//452-LowOptimized
import java.util.PriorityQueue;

public class MinArraysToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(findMinArrowShots(points));
    }

    static int findMinArrowShots(int[][] points) {
        int result = 0;

        // Sort the balloon ranges in ascending order of their end points to PriorityQueue.
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1]-b[1]);

        // add all the balloon ranges to the PriorityQueue
        for (int []point : points) priorityQueue.add(point);

        // if there are no balloons, return 0
        if (priorityQueue.isEmpty()) return 0;

        // while there are balloons, process each balloon range
        while (!priorityQueue.isEmpty()) {
            // get the current balloon range
            int [] prev = priorityQueue.poll();


            while (!priorityQueue.isEmpty() &&
                    prev[1]>=priorityQueue.peek()[0] &&
                    prev[1]<=priorityQueue.peek()[1]) {
                priorityQueue.poll();
            }

            result++;
        }
        return result;
    }
}
