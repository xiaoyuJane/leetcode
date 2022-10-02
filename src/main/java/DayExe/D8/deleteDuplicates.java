package DayExe.D8;

import TestAndTool.tool.ListNode;
import lombok.val;

public class deleteDuplicates {
    public static void main(String[] args) {
        Solution solution = new deleteDuplicates().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;
            ListNode cur = head;
            while (cur.next !=null){
                if (cur.val == cur.next.val) cur.next= cur.next.next;
                else cur=cur.next;
            }
            return head;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
