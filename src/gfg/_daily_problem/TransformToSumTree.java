package gfg._daily_problem;

public class TransformToSumTree {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);
        TransformToSumTree sol = new TransformToSumTree();
        sol.toSumTree(root);
        System.out.println("Sum Tree :");
        inorder(root);
    }
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    static void toSumTree(Node root){
        //add code here.
        update(root);
    }
    public static int update(Node root) {
        if(root==null) return 0;
        int d = root.data;
        root.data= update(root.left) + update(root.right);
        return root.data+d;
    }
}
