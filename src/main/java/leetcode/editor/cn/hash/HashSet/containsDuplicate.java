package leetcode.editor.cn.hash.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
 * 如果数组中每个元素互不相同，返回 false 。
 *  
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 相关标签
 * 数组
 * 哈希表
 * 排序

 */
public class containsDuplicate {
    public static void main(String[] args) {
        Solution solution = new containsDuplicate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int num :nums){
                if(set.contains(num)){
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
