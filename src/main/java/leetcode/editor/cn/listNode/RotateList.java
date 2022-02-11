package leetcode.editor.cn.listNode;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 722 👎 0

public class RotateList{
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
        ListNode head = new ListNode(1);
        ListNode curNode = head;
        curNode.next = new ListNode(2);
        curNode = curNode.next;
//        curNode.next = new ListNode(2);
//        curNode = curNode.next;
        ListNode res = solution.rotateRight(head,1);
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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null ||k==0) return head;

        ListNode curr = head;

        //1.成环并统计长度
        int length =1;
        while (curr.next!=null){
            length++;
            curr = curr.next;
        }
        curr.next = head;

        //2.计算位移
        int step = length - k%length -1;
        while (step-- >0){
            head = head.next;
        }

        //3.结果指向下一位
        ListNode res = head.next;
        //断开前面的环链
        head.next = null;

        return  res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}