package DayExe.DS2.D11;

import TestAndTool.tool.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class getIntersectionNode {
    public static void main(String[] args) {
        Solution solution = new getIntersectionNode().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB){

            ListNode pa = headA;
            ListNode pb = headB;

            while (pa!=pb){
                pa = pa==null ? headB: pa.next;
                pb = pb==null ? headA: pb.next;
            }
            return pa;

        }

        //使用hashMap试下
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while (headA!=null){
                set.add(headA);
                headA = headA.next;
            }

            while (headB!=null){
                if (set.contains(headB)) return headB;
                headB = headB.next;
            }
            return null;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
