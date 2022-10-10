package DayExe.D12;

import TestAndTool.tool.TreeNode;

import java.util.LinkedList;

public class invertTree {
    public static void main(String[] args) {
        Solution solution = new invertTree().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //递归
        public TreeNode invertTree(TreeNode root) {
           if (root == null) return null;
           if (root.left == null && root.right == null) return root;
          TreeNode tmp = invertTree(root.left);
          root.left = invertTree(root.right);
          root.right = tmp;
          return root;
        }

        //迭代
        //广度优先遍历的特点是层层扫荡，需要额外的数据结构--队列，来存放临时遍历到的元素
        //先将根节点放入到队列中，然后不断的迭代队列中的元素
        //对当前元素调换其左右子树的位置
        public TreeNode invertTree1(TreeNode root) {
            if (root == null) return null;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()){
                //对当层对结点进行处理，1 出队；2 交换左右结点
                TreeNode poll = queue.poll();
                TreeNode tmp = poll.left;
                poll.left = poll.right;
                poll.right = tmp;
                //入队处理
                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
            return root;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
