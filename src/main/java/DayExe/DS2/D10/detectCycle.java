package DayExe.DS2.D10;

import TestAndTool.tool.ListNode;

public class detectCycle {
    public static void main(String[] args) {
        Solution solution = new detectCycle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            if (head==null ||head.next == null) return null;
            slow = slow.next;
            fast=fast.next.next;

            //找到第一次相遇点
            while (fast!=slow){
                if (fast==null ||fast.next == null) return null;
                fast=fast.next.next;
                slow=slow.next;
            }

            //根据数学方法得到第一个环的点
            ListNode pre = head;
            while (pre!=slow){
                pre = pre.next;
                slow =slow.next;
            }

            return slow;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
