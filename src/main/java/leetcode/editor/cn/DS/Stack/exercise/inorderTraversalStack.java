package leetcode.editor.cn.DS.Stack.exercise;

import TestAndTool.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//二叉树的中序遍历
public class inorderTraversalStack {
    public static void main(String[] args) {
        Solution solution = new inorderTraversalStack().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 不使用系统栈（递归）形式，使用自己定义的栈来实现
     * 递归解决方案的优点是它更容易实现。
     * 但是，存在一个很大的缺点：如果递归的深度太高，你将遭受堆栈溢出。 在这种情况下，您可以使用显式栈实现 DFS
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root){

            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            List<Integer> res = new ArrayList<Integer>();
            //中序遍历，左中右的顺序

            while (root!=null ||!stack.isEmpty()){
                //1.找左子树
                while (root!=null){
                    stack.push(root);
                    root = root.left; //记录到左子树的路径节点
                }
                //弹出最近的左子节点
                TreeNode top = stack.pop(); //弹出最近的左子节点
                res.add(top.val);

                root = top.right; //遍历右子树

            }
            return res;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
