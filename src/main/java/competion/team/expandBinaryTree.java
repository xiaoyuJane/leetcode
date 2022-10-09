package competion.team;

import TestAndTool.tool.TreeNode;

public class expandBinaryTree {
    public static void main(String[] args) {
        Solution solution = new expandBinaryTree().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //递归
        public TreeNode expandBinaryTree(TreeNode root) {
            if (root == null) return null;
            if (root.left!=null) {
                TreeNode mid = new TreeNode(-1);
                mid.left = expandBinaryTree(root.left);
                root.left = mid;
            }
            if (root.right!=null) {
                TreeNode mid = new TreeNode(-1);
                mid.right = expandBinaryTree(root.right);
                root.right = mid;
            }


            return root;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
