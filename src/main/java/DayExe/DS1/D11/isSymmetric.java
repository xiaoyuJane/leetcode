package DayExe.DS1.D11;

import TestAndTool.tool.TreeNode;

import java.util.LinkedList;

public class isSymmetric {
    public static void main(String[] args) {
        Solution solution = new isSymmetric().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //递归解法
       public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSame(root.left,root.right);
        }

        public boolean isSame(TreeNode left,TreeNode right){
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            return isSame(left.left,right.right)&& isSame(left.right,right.left);
        }

        //迭代解法-使用队列存储，根据规律来
        public boolean isSymmetric2(TreeNode root) {
           if (root.left == null && root.right == null) return true;

            LinkedList<TreeNode> deque = new LinkedList<>();
            //按照比较的顺序存入队列
            deque.offer(root.left);
            deque.offer(root.right);
            while (!deque.isEmpty()){
                //出队
                TreeNode left = deque.poll();
                TreeNode right = deque.poll();
                //判断
                if (left == null && right == null) continue;;
                if (left == null || right == null) return false;
                if (left.val!=right.val) return false;

                //入队
                deque.offer(left.left);
                deque.offer(right.right);
                deque.offer(left.right);
                deque.offer(right.left);
            }
            return true;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
