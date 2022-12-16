package leet_code._daily_prob;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

//    public MyQueue(){}

     void push(int x){
        while (st1.empty()==false){
            st2.push(st1.peek());
            st1.pop();
        }
        st1.push(x);
        while(st2.empty()==false){
            st1.push(st2.peek());
            st2.pop();
        }
    }
    public int pop(){
        if (st2.empty())
            return -1;
        else
            return st2.pop();
    }
    public int peek(){
        if (st2.empty())
            return -1;
        else
            return st2.peek();
    }
    public boolean empty(){
        if(st1.empty())
            return true;
        else return false;
    }

    class Again{
        public static void main(String[] args) {
            MyQueue q = new MyQueue();
            q.push(3);
            q.push(4);
            System.out.println("The element poped is " + q.pop());
            q.push(5);
            System.out.println("The top element is " + q.peek());
            System.out.println("The size of the queue is " + q.size());
        }
    }

}
