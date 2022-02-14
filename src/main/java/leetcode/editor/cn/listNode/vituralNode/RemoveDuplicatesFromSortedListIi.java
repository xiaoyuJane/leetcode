package leetcode.editor.cn.listNode.vituralNode;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 
// 👍 800 👎 0

public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode head = new ListNode(1);
        ListNode curNode = head;
        curNode.next = new ListNode(2);
        curNode = curNode.next;
        curNode.next = new ListNode(3);
        curNode = curNode.next;
        curNode.next = new ListNode(3);
        ListNode res = solution.deleteDuplicates(head);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        //由于链表的头结点可能被删除，因此需要额外使用一个节点指向链表的头结点。链表都是引用,所以后续的改变都能改变整个链表
        //虚拟头节点的存在：1.当head有可能被删除，需要虚拟头结点 2.删除节点需要被删除节点的前一个节点
        ListNode dummy = new ListNode(101,head);

        ListNode cur = dummy;

        while (cur.next!=null && cur.next.next!=null){
            //1.判断后两位是否有相等的值
            if(cur.next.val == cur.next.next.val){
                //2.如果有，做删除操作
                int x = cur.next.val;
                while (cur.next !=null && cur.next.val == x){
                    cur.next = cur.next.next;  //单链表的删除操作
                }
            }
            //2.不存在相等，游标后移动
            else {
                cur = cur.next; //游标的移动操作
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}