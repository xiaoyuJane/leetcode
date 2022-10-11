package DayExe.D10;

import TestAndTool.tool.TreeNode;
import ch.qos.logback.classic.spi.EventArgUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
    public static void main(String[] args) {
        Solution solution = new inorderTraversal().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            //递归的边界条件，返回res即对res不做操作
            if (root == null) return res;
            //保证如下顺序，一定是先遍历，再add
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);

            return res;
        }

        public List<Integer> inorderTraversal1(TreeNode root) {
            if (root == null) return res;
            Stack<TreeNode> st = new Stack<>();
            while (root!=null ||!st.isEmpty()){
                //遍历左子树
                while (root !=null){
                    st.push(root);
                    root = root.left;
                }
                //左子树遍历完了,取左子树最左下的结点，加入res
                root= st.pop();
                res.add(root.val);
                //遍历最下结点的右子树
                root = root.right;
            }
            return res;
        }


        public List<Integer> postorderTraversal1(TreeNode root) {
            if (root == null) return res;
            TreeNode pre = null; //已遍历过的指针
            Stack<TreeNode> st = new Stack<>();
            while (root!=null ||!st.isEmpty()){
                //遍历左子树
                while (root !=null){
                    st.push(root);
                    root = root.left;
                }
                //左子树遍历完了,取左子树最左下的结点
                root= st.pop();
                //出栈条件： 右结点为空
                if (root.right == null || root.right == pre){
                    res.add(root.val);
                    pre = root;
                    root = null;
                }
                //右子树不空的时候，根结点继续入栈，遍历右结点
                else {
                    st.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
