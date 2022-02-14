package leetcode.editor.cn.iteration;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 
// 👍 1231 👎 0

public class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //头节点可能会改变的
        ListNode dummy = new ListNode(0,head);
        if (dummy.next == null || dummy.next.next==null) return head;

        //设置游标 tmp
        ListNode tmp = dummy;
        while (tmp.next!=null && tmp.next.next!= null){
            //用变量把要交换的两个节点保存起来
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            //断链的过程。tmp始终为指向要交换的第一个节点的节点
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            tmp = node1;
        }
        return dummy.next;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}