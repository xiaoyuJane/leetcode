package leetcode.editor.cn.BFS;

import TestAndTool.tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BiTreeBFSlevel {
    public static void main(String[] args) {
        Solution solution = new BiTreeBFSlevel().new Solution();
        TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(4);
        solution.BiTreeBFSlevel(tree);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二叉树的层序遍历,并统计层数
         */

        public void BiTreeBFSlevel(TreeNode tree){
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(tree);
            int level = 0;

            while (!queue.isEmpty()){
                int size = queue.size();  //size表示每一层的节点数

                for (int i=0;i<size;i++){
                    TreeNode node = queue.poll();
                    System.out.println("node.val:" +node.val);
                    if (node.left!=null) queue.offer(node.left);
                    if (node.right!=null) queue.offer(node.right);
                }

                level++; //遍历完每层后，level自加
                System.out.println(level);
            }

            System.out.println("level :"+level);
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
