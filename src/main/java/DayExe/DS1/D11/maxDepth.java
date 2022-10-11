package DayExe.DS1.D11;

import TestAndTool.tool.TreeNode;

import java.util.LinkedList;

public class maxDepth {
    public static void main(String[] args) {
        Solution solution = new maxDepth().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDepth1(TreeNode root) {
            int res = 0;
            LinkedList<TreeNode> deque = new LinkedList<>();
            if (root!=null) deque.offer(root);
            while (!deque.isEmpty()){
                int n = deque.size();
                for (int i = 0; i < n; i++) {
                    TreeNode poll = deque.poll();
                    if (poll.left!=null) deque.offer(poll.left);
                    if (poll.right!=null) deque.offer(poll.right);
                }
                res++;
            }
            return res;

        }

        //使用递归，二叉树的定义，天然的递归属性
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return Math.max(l,r)+1;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
