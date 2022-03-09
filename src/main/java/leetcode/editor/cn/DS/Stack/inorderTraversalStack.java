package leetcode.editor.cn.DS.Stack;

import TestAndTool.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

            while (root!=null ||!stack.isEmpty()){
                while (root!=null){
                    stack.push(root);
                    root = root.left;
                }
                TreeNode top = stack.pop();
                res.add(top.val);
                root = top.right;

            }
            return res;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
