package DayExe.DS1.D7;

import TestAndTool.tool.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * https://leetcode.cn/problems/remove-linked-list-elements/?plan=data-structures&plan_progress=slxu9ov
 */
public class removeElements {
    public static void main(String[] args) {
        Solution solution = new removeElements().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //todo 可尝试使用递归的方式解决
        public ListNode removeElements(ListNode head, int val) {
            ListNode prehead = new ListNode(-1);
            ListNode pre = prehead;

            while (head!=null){
                if (head.val == val){
                    head = head.next;
                    pre.next = null;
                }else {
                    pre.next = head;
                    head = head.next;
                    pre = pre.next;
                }
                pre.next = null;

            }
            return prehead.next;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
