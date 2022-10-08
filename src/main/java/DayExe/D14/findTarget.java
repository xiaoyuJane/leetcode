package DayExe.D14;

import TestAndTool.tool.TreeNode;
import ch.qos.logback.classic.spi.EventArgUtil;

import java.util.HashSet;

public class findTarget {
    public static void main(String[] args) {
        Solution solution = new findTarget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //本质还是查找，已知一个元素，查找另一个元素，返回的结果是true或者false
        HashSet<Integer> set = new HashSet<>();
        public boolean findTarget(TreeNode root, int k) {
          if (root == null) return false;

            //找到了
            if (set.contains(k-root.val)) return true;
            //没找到，记录已遍历过的元素，找其下一个
            else set.add(root.val);
            //分两路查找
            return findTarget(root.left,k) || findTarget(root.right,k);

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
