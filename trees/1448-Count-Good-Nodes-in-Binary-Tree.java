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
    public int goodNodes(TreeNode root) {
        ArrayList<Integer>res=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        goodNodes1(res,max,root);
        return res.size();
    }
    public static void  goodNodes1(ArrayList<Integer>res,int max,TreeNode root){
         if(root==null){
            return;
        }
        if(root.val>=max){
            
            res.add(root.val);
            max=root.val;
        }
       
        goodNodes1(res,max,root.left);
        goodNodes1(res,max,root.right);
    }
}