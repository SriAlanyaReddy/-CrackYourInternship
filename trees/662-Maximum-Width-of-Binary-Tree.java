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
 class Pair{
    TreeNode root;
    int second;
    Pair(TreeNode root,int second){
       this.root=root;
        this.second=second;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair>q=new LinkedList<>();
        int maxwidth=Integer.MIN_VALUE;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
          int n=q.size();
          int mmin=q.peek().second;
          int first_id=0;
          int last_id=0;
          for(int i=0;i<n;i++){
            Pair current=q.poll();
            int currentpos=current.second-mmin;
            if(i==n-1) last_id=currentpos;
            if(i==0) first_id=currentpos;
            
            if(current.root.left!=null){
                q.add(new Pair(current.root.left,2*currentpos+1));
            }
            if(current.root.right!=null){
                 q.add(new Pair(current.root.right,2*currentpos+2));
            }
          }
          maxwidth=Math.max(maxwidth,last_id-first_id+1);
        }
        return maxwidth;
    }
}