package competion.tianchi2022;

import TestAndTool.tool.ListNode;

public class numberEvenListNode {
    public static void main(String[] args) {
        Solution solution = new numberEvenListNode().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberEvenListNode(ListNode head) {
            int res = 0;
            while (head!=null){
                if (head.val%2==1) res++;
                head=head.next;
            }
            return res;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
