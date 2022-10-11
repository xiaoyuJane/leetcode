package DayExe.DS1.D10;

import TestAndTool.tool.TreeNode;

import java.util.*;

public class preorderTraversal {
    public static void main(String[] args) {
        Solution solution = new preorderTraversal().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Integer> res = new ArrayList<>();

        //递归方法
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return res;

            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return res;
        }

        //迭代方法-栈保存顺序
        public List<Integer> preorderTraversal2(TreeNode root) {
            if (root == null) return res;
            Stack<TreeNode> st = new Stack<>();
            st.push(root);
            while (!st.isEmpty()){
                TreeNode pop = st.pop();
                res.add(pop.val);
                if (pop.right!=null) st.push(pop.right);
                if (pop.left!=null) st.push(pop.left);
            }
            return res;
        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
