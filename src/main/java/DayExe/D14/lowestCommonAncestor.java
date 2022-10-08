package DayExe.D14;

import TestAndTool.tool.TreeNode;

import java.util.HashMap;
import java.util.List;

public class lowestCommonAncestor {
    public static void main(String[] args) {
        Solution solution = new lowestCommonAncestor().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //利用搜索二叉树的性质
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode res = root;
            while (true){
                if (p.val< root.val && q.val < root.val) res = res.left;
                else if (p.val>root.val && q.val>root.val) res = res.right;
                else break;
            }
            return res;
        }


    }
//leetcode submit region begin(Prohibit modification and deletion)
}
