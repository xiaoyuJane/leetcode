package competion.doubleCom.c88;

import java.util.ArrayList;

public class xorAllNums {
    public static void main(String[] args) {
        Solution solution = new xorAllNums().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int xorAllNums(int[] nums1, int[] nums2) {
            int res = nums1[0] ^ nums2[0];
            for (int i = 1; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    res = res ^ (nums1[i]^nums2[j]);
                }
            }
            for (int j = 1; j < nums2.length; j++) {
                res = res ^(nums1[0] ^nums2[j]);
            }

            return res;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
