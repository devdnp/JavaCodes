package d100._2day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    static int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertIt(intervals, newInterval);

        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            while (i < intervals.length && isOverlapping(currInterval, intervals[i])) {
                currInterval = merge(currInterval, intervals[i]);
                i++;
            }
            i--;
            answer.add(currInterval);
        }

        return answer.toArray(new int[answer.size()][2]);
    }

    static int[][] insertIt(int[][] intervals, int[] newInterval) {
        boolean isIntervalInserted = false;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                list.add(i, newInterval);
                isIntervalInserted = true;
                break;
            }
        }
        if (!isIntervalInserted) {
            list.add(newInterval);
        }
        return list.toArray(new int[list.size()][2]);
    }

    static boolean isOverlapping(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    static int[] merge(int[] a, int[] b) {
        int[] newInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return newInterval;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        System.out.println(Arrays.deepToString(insert(intervals,newInterval)));
    }
}
