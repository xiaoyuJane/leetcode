package DayExe.DS2.D12;

import TestAndTool.tool.ListNode;

public class swapPairs {
    public static void main(String[] args) {
        Solution solution = new swapPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //可以用递归
        public ListNode swapPairs(ListNode head) {
            if (head==null||head.next==null) return head;

            ListNode h = swapPairs(head.next.next);
            ListNode tmp = head.next;
            head.next.next = head;
            head.next = h;
            return tmp;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
