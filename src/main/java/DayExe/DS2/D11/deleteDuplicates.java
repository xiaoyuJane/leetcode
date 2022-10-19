package DayExe.DS2.D11;

import TestAndTool.tool.ListNode;

public class deleteDuplicates {
    public static void main(String[] args) {
        Solution solution = new deleteDuplicates().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //迭代和删除，需要重点吃透
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;

            ListNode pre = new ListNode(0,head);
            ListNode curr = pre;

            //至少两个节点
            while (curr.next!=null && curr.next.next!=null){
                //有两个元素相同的时候，先取一个基准tmp
                if (curr.next.val == curr.next.next.val){
                    int tmp = curr.next.val;
                    //使用while循环逐个判断curr.next，一个个删
                    while (curr.next!=null && curr.next.val==tmp){
                        curr.next = curr.next.next; //单链表的删除节点的操作
                    }
                }
                //不相同的情况下，curr直接后移动
                else {
                    curr = curr.next;
                }
            }
            //兼容了一个节点的情况，一个节点上述while不走，直接返回head
            return pre.next;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
