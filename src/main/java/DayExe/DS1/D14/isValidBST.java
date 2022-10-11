package DayExe.DS1.D14;

import TestAndTool.tool.TreeNode;

import java.util.LinkedList;

public class isValidBST {
    public static void main(String[] args) {
        Solution solution = new isValidBST().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        节点的左子树只包含 小于 当前节点的数。
//        节点的右子树只包含 大于 当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。
        //递归中不满足于父节点了，而是着眼于根节点，最早的祖先节点
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);

        }

        private boolean isValidBST(TreeNode curr,long min ,long max){
            //边界条件
            if (curr == null) return true;

            if (curr.val>min && curr.val<max){
                //缩小了范围
                return isValidBST(curr.left,min,curr.val) && isValidBST(curr.right,curr.val,max);
            }
            return false;

        }


        //迭代法
        // 二叉搜索树「中序遍历」得到的值构成的序列一定是升序的
        // 在做中序遍历的时候判断当前节点的值是否大于前一个节点的值
        public boolean isValidBST1(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            double pre = -Double.MAX_VALUE;

            while (!stack.isEmpty() || root!=null){
                //左子树入栈
                while (root!=null){
                    stack.push(root);
                    root = root.left;
                }
                //出栈
                TreeNode pop = stack.pop();
                if (pop.val <= pre) return false;
                pre = pop.val;
                //右子树入栈
                root = pop.right;
            }
            return true;

        }


    }
//leetcode submit region begin(Prohibit modification and deletion)
}
