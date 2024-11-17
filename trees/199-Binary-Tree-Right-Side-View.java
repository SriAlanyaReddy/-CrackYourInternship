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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer>res=new ArrayList<>();
        rightview(root,0,res);
        return res;
    }
    public static void  rightview(TreeNode root,int depth,ArrayList<Integer>res){
        if(root==null){
            return;
        }
        if(depth==res.size()){
            res.add(root.val);
        }
        rightview(root.right,depth+1,res);
        rightview(root.left,depth+1,res);
    }
}