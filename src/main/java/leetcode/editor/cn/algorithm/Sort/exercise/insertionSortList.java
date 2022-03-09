package leetcode.editor.cn.algorithm.Sort.exercise;

import TestAndTool.tool.ListNode;

/**
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 *
 * 插入排序 算法的步骤:
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。
 * 每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 *
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 *
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 *
 * 提示：
 *
 * 列表中的节点数在 [1, 5000]范围内
 * -5000 <= Node.val <= 5000
 * 相关标签
 * 链表
 * 排序
 */
public class insertionSortList {
    public static void main(String[] args) {
        Solution solution = new insertionSortList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(0,head); //引入哑节点是为了便于在 head 节点之前插入节点

            ListNode lastSorted = head; //已排序部分的最后一个节点
            ListNode current = head.next; //从第二个节点开始比较

            while (current!=null){
                if (current.val<lastSorted.val){
                    //从头寻找next的合适位置
                    ListNode pre  = dummy;
                    //找到比next值大的第一个数的位置
                    while (pre.next.val <= current.val) pre =pre.next;
                    //此时的previous.next是大于current值的位置
                    lastSorted.next = current.next; //把current拿上来，即断开laststore与current的链
                    current.next = pre.next;   //把current插入到pre后面，先断pre的next
                    pre.next = current;        //把pre的next赋值给current

                }else {
                    lastSorted = lastSorted.next;
                }
                //更新current值
                current  = lastSorted.next;
            }

            return dummy.next;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
