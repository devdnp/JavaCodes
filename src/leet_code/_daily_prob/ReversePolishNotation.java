package leet_code._daily_prob;


import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] str = {"2", "1", "+", "3", "*"};
        int result = evalRPN(str);
        System.out.println(result);
    }

    static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s)) stack.push(stack.pop() + stack.pop());
            else if ("-".equals(s)) stack.push(-stack.pop() + stack.pop());
            else if ("/".equals(s)) stack.push((int) (1D / stack.pop() * stack.pop()));
            else if ("*".equals(s)) stack.push(stack.pop() * stack.pop());
            else stack.push(Integer.valueOf(s));
        }

        return stack.pop();
    }
}