package leetcode.editor.cn.iteration;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 2266 👎 0


//迭代算法
public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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
    public ListNode reverseList(ListNode head) {
        // 在遍历链表时，将当前节点的next指针改为指向前一个节点，这里需要定义一个存储前节点的pre

        ListNode prev = null;  //新的头指针
        ListNode curr = head;  //游标
        while (curr!=null){
            ListNode next = curr.next; //后节点

            //***更改指针方向 开始*******
            curr.next = prev;  //更改指向后节点的指针为指向前节点
            prev = curr; //前节点后移
            curr = next; //游标后移指向当前节点的后节点
            //***更改指针方向 结束*******
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}