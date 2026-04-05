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
    int preindex=0;
    Map<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int instart, int inend){
        if(instart>inend) return null;
        int rootval=preorder[preindex++];
        TreeNode root=new TreeNode(rootval);

        int index=map.get(rootval);

        root.left=helper(preorder, instart, index-1);
        root.right=helper(preorder, index+1, inend);

        return root;
    }
}