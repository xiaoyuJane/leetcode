package DayExe.DS1.D7;

import TestAndTool.tool.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan&id=shu-ju-jie-gou-ru-men
 */
public class mergeTwoLists {
    public static void main(String[] args) {
        Solution solution = new mergeTwoLists().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //常规思路：迭代
        //todo 可尝试使用递归的方式解决
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            //pre负责不断创建链表，而prehead不移动，始终指向创建链表的第一个元素
            ListNode prehead = new ListNode(-1);
            ListNode pre = prehead;

            //情况1：当两个链表都不为空的时候进行遍历
           while (list1 !=null && list2!=null){
               //pre的next始终指向较小的
               if (list1.val <= list2.val) {
                   pre.next=list1;
                   list1 = list1.next;
               }else {
                   pre.next = list2;
                   list2 = list2.next;
               }
               pre =pre.next;
           }
           //情况2：有一个链表为空的情况下，直接返回另外一个链表即可
           pre.next = list1==null? list2:list1;

           return prehead.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
