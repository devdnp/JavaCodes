package leet_code.easy;

import javax.swing.tree.TreeNode;
import java.util.*;

public class BinaryTreePreorderTraversal {
    static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(preorderTraversal(root));
    }

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                result.add(root.val);
                stack.add(root);
                root=root.left;
            }
            if(stack.isEmpty()){
                return result;
            }
            root=stack.pop();
            root=root.right;
        }
        return result;
    }
}
