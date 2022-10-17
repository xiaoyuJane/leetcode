package DayExe.DS2.D10;

import TestAndTool.tool.ListNode;

import java.util.List;

public class addTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new addTwoNumbers().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry =0;
            ListNode pre = new ListNode();
            ListNode first = pre;
            while (l1!=null || l2!=null){
                int val;
                if (l1!=null && l2!=null){
                    val = (carry+l1.val+l2.val)%10;
                    carry = (carry+l1.val+l2.val)/10;
                    first.next = new ListNode(val);
                    l1=l1.next;
                    l2=l2.next;
                    first = first.next;
                }
                else if (l1 == null){
                    val = (carry+l2.val)%10;
                    carry = (carry+l2.val)/10;
                    first.next = new ListNode(val);
                    l2=l2.next;
                    first = first.next;
                }
                else {
                    val = (carry+l1.val)%10;
                    carry = (carry+l1.val)/10;
                    first.next = new ListNode(val);
                    l1=l1.next;
                    first = first.next;
                }
            }
            if (carry!=0)   first.next = new ListNode(carry);

            return pre.next;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
