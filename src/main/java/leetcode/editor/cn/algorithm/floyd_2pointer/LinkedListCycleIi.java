package leetcode.editor.cn.algorithm.floyd_2pointer;

//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
// Related Topics 哈希表 链表 双指针 
// 👍 1365 👎 0

/**
 * 典型的floy 算法
 *（3）如何确定环的起点 （slow和fast同时出发）
 * 假设相遇点为B点。
 * 方法是将其中一个指针移到链表起点，另一个指针为B点,两者同时移动，每次移动一步，那么两者相遇的地方就是环的起点。
 * 数学计算方法： i=slow指针走过的步数；m=head到环起点start的距离；n=环的长度；k=start到相遇位置的距离
 * i = m+n*a+k （a为slow走过的圈数）
 * 2*i = m+n*b+k （b为fast走过的圈数）
 * 上述相减得到 i=n*（b-a）
 */

public class LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if (fast == null || fast.next == null) return  null;
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next;
        while (head!=slow){
            slow = slow.next;
            head = head.next;
        }
       return head;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}