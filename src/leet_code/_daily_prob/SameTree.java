package leet_code._daily_prob;

public class SameTree {
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
    static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        SameTree sol = new SameTree();
        System.out.println(sol.isSameTree(p, q));
    }
}