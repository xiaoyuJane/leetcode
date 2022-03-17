package leetcode.editor.cn.DS.List.array.exercise;

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 0 <= k <= 105 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 429 👎 0

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
static class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> temp = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (temp.containsKey(nums[i]) && (i-temp.get(nums[i]))<=k){
                return true;
            }else temp.put(nums[i],i);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}