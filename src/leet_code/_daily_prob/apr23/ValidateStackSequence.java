package leet_code._daily_prob.apr23;
//13Apr
//946
import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequence {

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0; // popped's index

        for (final int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                ++i;
            }
        }

        return stack.isEmpty();
    }
}

