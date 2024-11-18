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
    public int diameterOfBinaryTree(TreeNode root) {
        //my approcah is to solve by using the longest path between any two nodes issum of max height of left subtree & rightsubtree
        int[] dim = new int[1];
        maxheight(root,dim);
        return dim[0];
    }
       public int maxheight(TreeNode root,int dim[]) {
        if(root==null){
            return 0;
        }
        int leftheight=maxheight(root.left,dim);
        int rightheight=maxheight(root.right,dim);
         dim[0]=Math.max(leftheight+rightheight,dim[0]);
        return Math.max(leftheight,rightheight)+1;
       }
}