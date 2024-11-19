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
    public int sumNumbers(TreeNode root) {
      ArrayList<Integer>res=new ArrayList<>()  ;
      StringBuilder sb=new StringBuilder();
      summing(root,res,sb);
      return res.stream().mapToInt(Integer::intValue).sum();
    }
    public static void summing(TreeNode root,ArrayList<Integer>res,StringBuilder sb){
        if(root==null) return;
        sb.append(Integer.toString(root.val));
        if(root.left==null && root.right==null) {
            res.add(Integer.parseInt(sb.toString()));
            }
        summing(root.left,res,sb);
        summing(root.right,res,sb);
         sb.setLength(sb.length() - 1);
    }
}