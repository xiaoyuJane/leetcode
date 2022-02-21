package leetcode.editor.cn.listNode.recursion;

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

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
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
    public ListNode swapPairs(ListNode head) {
        return reverse(head);

    }

    private ListNode reverse(ListNode before){

        //2.递归终止条件
        if (before == null) return null;
        if (before.next == null) {
            return before;
        }

        //1.向下递的过程
        ListNode res = reverse(before.next.next);

        //3.向上归的过程
        ListNode end = before.next;
        before.next.next= before;
        before.next = res;

        return end;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}