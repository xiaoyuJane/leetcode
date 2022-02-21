package leetcode.editor.cn.listNode.recursion;

//给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。 
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 104 
// -106 <= Node.val <= 106 
// 
// Related Topics 链表 
// 👍 537 👎 0

public class OddEvenLinkedList{
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
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

    //巧妙在这里，利用全局变量来存储变化的值
    ListNode last_odd = null;
    ListNode first_even = null;

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        //终止条件
        if (head.next == null || head.next.next == null){
            last_odd = head;
            first_even = head.next;
            return  head;
        }
        //向下递
        ListNode res = oddEvenList(head.next.next);

        //向上归
        ListNode second = head.next;
        head.next = res;
        last_odd.next = second;
        second.next = first_even;
        //更改第一个even值
        first_even = second;

        return head;
    }





}
//leetcode submit region end(Prohibit modification and deletion)

}