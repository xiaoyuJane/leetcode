package leetcode.editor.cn.DS.hash.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 相关标签
 * 位运算
 * 数组

 */
public class singleNumber {
    public static void main(String[] args) {
        Solution solution = new singleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                if(set.contains(num)) set.remove(num);
                else set.add(num);
            }
            return set.iterator().next();

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
