package DayExe.D7;
/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import TestAndTool.tool.ListNode;

public class hasCycle {
    public static void main(String[] args) {
        Solution solution = new hasCycle().new Solution();

    }


    class Solution {
        //数学法+思考+双指针
        public boolean hasCycle(ListNode head) {
            //成环至少两个结点
            if (head == null || head.next == null) return false;

            ListNode fast = head.next.next, slow = head.next;
            //循环结束条件是两者相遇
            while (slow!=fast){
                //循环体处理的是未相遇可能出现的两种情况
                //1.当fast遇到了尾结点，说明没有成环
                if (fast == null ||fast.next==null) return false;
                //2.否则移动指针，没有结束结点的时候，肯定会相遇
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
