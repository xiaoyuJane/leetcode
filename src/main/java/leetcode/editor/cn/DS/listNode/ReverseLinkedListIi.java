package leetcode.editor.cn.DS.listNode;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 1152 👎 0

public class ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        //定义dummy节点，方便处理
       ListNode dummy = new ListNode(501,head);

       //初始化两个节点
       ListNode pre = dummy; //pre指向head之前位置
       ListNode current = dummy.next; //current 指向head

       //将指针移动left距离到相应位置，得到pre和current
       for (int i=0;i<left-1;i++){
           pre = pre.next;
           current = current.next;
       }

       //头插法插入节点（思路：把left之后的节点删除，使用头插法插入到pre和left之间，最后是left和right+1位置挨着）
        //pre 和current不再移动
       for (int j=0; j<right-left;j++){  //把left之后的节点删除，删除的节点数为right-left个
           ListNode remove = current.next; //1.保存待删除节点
           current.next = current.next.next; //2.将后一个节点移到前面来，变成current.next

           //头插法,始终插在pre的后面
           remove.next = pre.next; //3.待删除节点指向pre.next，即current节点
           pre.next = remove; //4.pre节点断开与current联系，指向remove
       }

       return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}