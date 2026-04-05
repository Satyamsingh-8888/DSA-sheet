/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markparent(TreeNode root, Map<TreeNode, TreeNode> parenttrack, TreeNode target){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr.left!=null){
                parenttrack.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                parenttrack.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parenttrack=new HashMap<>();
        markparent(root, parenttrack, root);
        Map<TreeNode, Boolean> vis=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(target);
        vis.put(target, true);
        int curr_level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0; i<size; i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    queue.offer(curr.left);
                    vis.put(curr.left, true);
                }

                if(curr.right!=null && vis.get(curr.right)==null){
                    queue.offer(curr.right);
                    vis.put(curr.right, true);
                }

                if(parenttrack.get(curr)!=null && vis.get(parenttrack.get(curr))==null){
                    queue.offer(parenttrack.get(curr));
                    vis.put(parenttrack.get(curr), true);
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            res.add(curr.val);
        }
        return res;
    }
}