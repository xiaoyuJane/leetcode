package leetcode.editor.cn.DS.listNode.recursion;

//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 
// 👍 801 👎 0

public class RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
    }
    //增加了数组转化为链表的实现
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
    public ListNode removeElements(ListNode head, int val) {

        //递归终止条件
        if (head == null) return head;
        //向下递
        head.next = removeElements(head.next,val); //从后往前，是为了找出当前节点的下个节点是啥，所以用head.next= xx
        //向上归
        if (head.val == val) head = head.next; //删除当前节点


        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}