package DayExe.DS1.D11;

import TestAndTool.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelOrder {
    public static void main(String[] args) {
        Solution solution = new levelOrder().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<TreeNode> deque = new LinkedList<>();

            //入队之前需要判空
            if (root!=null) deque.offer(root);
            while (!deque.isEmpty()){
                //2 拿到单层对个数
                int n = deque.size();
                List<Integer> item = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    TreeNode poll = deque.poll();
                    //3 使用i，对单层出队
                    item.add(poll.val);
                    //1 单层入队
                    if (poll.left!=null) deque.offer(poll.left);
                    if (poll.right!=null) deque.offer(poll.right);
                }
                res.add(item);

            }
            return res;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
