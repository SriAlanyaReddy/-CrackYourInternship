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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
         int n=q.size();
         List<TreeNode> nodes = new ArrayList<>();
         for(int i=0;i<n;i++){
            TreeNode node=q.poll();
            nodes.add(node);
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
         }
         if(level%2==1){
            int j=nodes.size()-1;
            int i=0;
            while(i<=j){
                int t=nodes.get(i).val;
                nodes.get(i).val=nodes.get(j).val;
                nodes.get(j).val=t;
                j--;
                i++;
            }
         }
        
         level++;
         
        }
        return root;

    }
   
}