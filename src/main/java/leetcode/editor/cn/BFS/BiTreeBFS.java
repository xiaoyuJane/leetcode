package leetcode.editor.cn.BFS;


import TestAndTool.traverse.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BiTreeBFS {
    public static void main(String[] args) {
        Solution solution = new BiTreeBFS().new Solution();
        TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(4);
        solution.BiTreeBFS(tree);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二叉树的层序遍历
         */

        public void BiTreeBFS(TreeNode tree){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(tree);

            while (!queue.isEmpty()){

                TreeNode node = queue.poll();
                System.out.println(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
