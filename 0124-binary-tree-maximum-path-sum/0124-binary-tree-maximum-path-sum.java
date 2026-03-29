/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxsum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findmax(root);
        return maxsum;
    }

    private int findmax(TreeNode root){
        if(root==null) return 0;
        int l=findmax(root.left);
        int r=findmax(root.right);
        if(l<0) l=0;
        if(r<0) r=0;
        int currpath=l+r+root.val;
        if(currpath>maxsum){
            maxsum=currpath;
        }
        return root.val+Math.max(l, r);
    }
}