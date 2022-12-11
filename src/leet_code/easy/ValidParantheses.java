package leet_code.easy;

import java.util.Stack;

public class ValidParantheses {
    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else if(st.isEmpty()) return false;
            else if(st.peek()=='(' && c!=')'
                    ||st.peek()=='{' && c!='}'
                    ||st.peek()=='[' && c!=']')  return false;
            else st.pop();
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}"; //"(]"
        System.out.println(isValid(s));
    }
}
