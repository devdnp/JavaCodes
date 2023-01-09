package d100._7day;

import java.util.Arrays;
import java.util.Stack;

//NOT COMPLETE, OUTPUT NOT CORRECT
public class DailyTemperatures {
    static int[] dailyTemperatures(int[] T) {
//        int[] ans = new int[T.length];
//        int[] next = new int[101];
//        Arrays.fill(next, Integer.MAX_VALUE);
//        for (int i = T.length - 1; i >= 0; i--) {
//            int warmer_index = Integer.MAX_VALUE;
//            for (int t = T[i] + 1; t <= 100; t++) {
//                if (next[t] < warmer_index) {
//                    warmer_index = next[t];
//                }
//            }
//            if (warmer_index < Integer.MAX_VALUE) {
//                ans[i] = warmer_index - 1; // -1 ?
//            }
//            next[T[i]] = i;
//        }
//
//        return ans;
        int n = T.length;

        // To store the answer
        int[] daysOfWait = new int[n];
        Arrays.fill(daysOfWait, -1);

        Stack<Integer> s = new Stack<>();

        // Traverse all the temperatures
        for(int i = 0; i < n; i++) {

            // Check if current index is the
            // next warmer temperature of
            // any previous indexes
            while (!s.isEmpty() && T[s.peek()] < T[i]) {
                daysOfWait[s.peek()] = i - s.peek();

                // Pop the element
                s.pop();
            }

            // Push the current index
            s.push(i);
        }
        return daysOfWait;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
