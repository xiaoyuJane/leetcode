package DayExe.DS1.D13;

import TestAndTool.tool.TreeNode;

public class insertIntoBST {
    public static void main(String[] args) {
        Solution solution = new insertIntoBST().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val<root.val)  root.left = insertIntoBST(root.left,val);
            if (val>root.val)  root.right =insertIntoBST(root.right,val);
            return root;
        }




    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
