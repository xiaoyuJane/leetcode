package leetcode.editor.cn.floyd_2pointer;

//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 哈希表 链表 双指针 
// 👍 1347 👎 0


/**
 * floyd 判圈算法
 * 快慢指针，双指针
 *（1）判断是否有环？
 * 龟兔解法的基本思想可以用我们跑步的例子来解释：
 * 如果两个人同时出发，如果赛道有环，那么快的一方总能追上慢的一方。进一步想，追上时快的一方肯定比慢的一方多跑了几圈，即多跑的路的长度是圈的长度的倍数。
 * 基于上面的想法，
 * Floyd用两个指针，一个慢指针（龟）每次前进一步，快指针（兔）指针每次前进两步（两步或多步效果时等价的，只要一个比另一个快就行）。
 * 如果两者在链表头以外的某一点相遇（即相等）了，那么说明链表有环，否则，如果（快指针）到达了链表的结尾，那么说明没坏。

 */
public class LinkedListCycle{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        //while循环，循环条件优先于循环体，可以想象为快慢都是从head之前的虚拟节点出发，下一步到达head和head.next
        while (slow!=fast){
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}