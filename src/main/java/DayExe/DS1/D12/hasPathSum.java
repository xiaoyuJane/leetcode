package DayExe.DS1.D12;

import TestAndTool.tool.TreeNode;

import java.util.LinkedList;

public class hasPathSum {
    public static void main(String[] args) {
        Solution solution = new hasPathSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //回溯
        public boolean hasPathSum1(TreeNode root, int targetSum) {
            if (root == null) return false;

            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> vals = new LinkedList<>();
            queue.offer(root);
            vals.offer(root.val);
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                Integer val = vals.poll();
                //判断是否到达叶子结点🍃
                if (poll.left==null&& poll.right==null){
                    if (val == targetSum) return true;
                    continue;
                }
                if (poll.left!=null) {
                    queue.offer(poll.left);
                    vals.offer(poll.left.val + val);
                }
                if (poll.right!=null) {
                    queue.offer(poll.right);
                    vals.offer(poll.right.val+val);
                }
            }
            return false;

        }

        //递归，二叉树的题目一般都可用递归解决
        public boolean hasPathSum(TreeNode root,int targetSum){
            if (root == null) return false;
            if (root.left == null && root.right== null) return targetSum == root.val;

            return hasPathSum(root.left,targetSum-root.val)
                    || hasPathSum(root.right,targetSum-root.val);
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
