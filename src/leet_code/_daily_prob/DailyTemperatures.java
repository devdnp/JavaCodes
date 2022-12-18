package leet_code.medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack= new Stack();
        int[] answer = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = stack.peek() - i;
            }

            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}