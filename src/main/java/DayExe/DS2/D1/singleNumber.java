package DayExe.DS2.D1;

import java.util.HashSet;

public class singleNumber {
    public static void main(String[] args) {
        Solution solution = new singleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.contains(num)) set.add(num);
                else set.remove(num);
            }
            return set.iterator().next();

        }

        //异或运算的两个性质
        // 一个数出现两次，自己异或自己=0
        // 0异或任何数=任何数
        // 异或运算具有平等的交换律
        public int singleNumber1(int[] nums) {
            int res=0;
            for (int num : nums) {
                res = res ^ num;
            }
            return res;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
