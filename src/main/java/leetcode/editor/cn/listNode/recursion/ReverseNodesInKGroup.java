package leetcode.editor.cn.listNode.recursion;

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 递归 链表 
// 👍 1470 👎 0

public class ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(arr);
        ListNode res = solution.reverse(head,3);

    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      public ListNode(int[] nums){
          this.val = nums[0];
          ListNode curr = this;
          for (int i=1;i<nums.length;i++){
              curr.next = new ListNode(nums[i]);
              curr = curr.next;
          }
      }

      @Override
      public String toString(){
          StringBuilder s = new StringBuilder();
          ListNode cur = this;
          while (cur !=null){
              s.append(cur.val);
              s.append(" -> ");
              cur = cur.next;
          }
          s.append("null");
          return s.toString();
      }
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
    public ListNode reverseKGroup(ListNode head, int k) {

        return reverse(head, k);
    }

    private ListNode reverse(ListNode head,int k){
        //递归终止条件
        ListNode dummy = new ListNode(0,head);
        ListNode curr = dummy;
        int step = k; //k应该为常量，不能被改变，所以这里用step来表示
        while (step-->0){
            curr = curr.next;
            if (curr == null) return dummy.next;
        }

        //向下递的过程

        ListNode res = reverse(curr.next,k);

        //向上归的过程,参考了迭代翻转链表的例子
        ListNode pre = res;
        ListNode cur = head;
        while (k-- >0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}