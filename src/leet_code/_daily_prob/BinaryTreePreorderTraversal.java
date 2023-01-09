package leet_code._daily_prob;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    private static List<Integer> answer = new ArrayList<>();
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
        System.out.println(preorderTraversal(root));
    }

    static List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return answer;
    }
    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // Visit the root first, then the left subtree, then the right subtree.
        answer.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
