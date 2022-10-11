package DayExe.DS1.D13;

import TestAndTool.tool.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class searchBST {
    public static void main(String[] args) {
        Solution solution = new searchBST().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //递归
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;

            if (root.val == val) return root;
            if (val<root.val) return searchBST(root.left,val);
            else return searchBST(root.right,val);
        }

        //迭代解法
        public TreeNode searchBST1(TreeNode root, int val){
            //迭代的终止条件是root==null
            while (root!=null){
                if (val == root.val) return root;
                root = val<root.val ? root.left:root.right;
            }
            return null;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
