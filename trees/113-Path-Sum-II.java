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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>l1=new ArrayList<>();
        pathsumm(root,targetSum,res,l1);
        return res;
    }
    public void pathsumm(TreeNode root,int targetSum,List<List<Integer>>res,List<Integer>l1){
        if(root==null){
            return;
        }
         l1.add(root.val);
        if(root.left==null && root.right ==null && targetSum==root.val){
            
            res.add(new ArrayList<>(l1));
        }
       
       
        //including
        pathsumm(root.left,targetSum-root.val,res,l1);
        pathsumm(root.right,targetSum-root.val,res,l1);
        l1.remove(l1.size()-1);


    }

}