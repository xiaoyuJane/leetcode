package leetcode.editor.cn.DS.listNode;

//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 789 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 链表转变为数组
 */
public class ReorderList{
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
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
    public void reorderList(ListNode head) {

        //1.存入链表中
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode current = head;
        while (current !=null){
            list.add(current);
            current = current.next;
        }

        //2.双指针.利用下标规律重建链表
        int i=0,j=list.size()-1;
        while (i<j-1){
            list.get(j).next = list.get(i).next;
            list.get(i).next = list.get(j);
            i++;
            j--;
        }
        list.get(j).next = null;




    }
}
//leetcode submit region end(Prohibit modification and deletion)

}