package DayExe.D8;

import TestAndTool.tool.ListNode;

import java.nio.file.LinkOption;

public class reverseList {
    public static void main(String[] args) {
        Solution solution = new reverseList().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseList1(ListNode head) {
            if (head == null ||head.next == null) return head;
            ListNode pre = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return pre;
        }

        //todo 使用迭代的方法解决
        public ListNode reverseList(ListNode head) {
          return head;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
