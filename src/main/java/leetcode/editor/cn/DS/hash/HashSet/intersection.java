package leetcode.editor.cn.DS.hash.HashSet;

import java.util.*;

/**
 * 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 相关标签
 * 数组
 * 哈希表
 * 双指针
 * 二分查找
 * 排序
 *
 */
public class intersection {
    public static void main(String[] args) {
        Solution solution = new intersection().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用两个set来存储
        public int[] intersection(int[] nums1, int[] nums2) {
          Set<Integer> set = new HashSet<>();
          for (int num : nums1){
              if (!set.contains(num)) set.add(num);
          }

          Set<Integer>  res = new HashSet<>();
          for (int num : nums2){
              if (set.contains(num)) res.add(num);
          }

          //将set转化为int[]
          int[] nums = new int[res.size()];
          int i = 0;
          for (int num :res){
              nums[i++] = num;
          }
          return  nums;
        }


        //使用hashmap来做
        public int[] intersection2(int[] nums1, int[] nums2){
            Map<Integer,Boolean> map = new HashMap<>();
            for (int num: nums1){
                if (!map.containsKey(num)) map.put(num,false);
            }
            for (int num: nums2){
                if(map.containsKey(num)) map.put(num,true);
            }
            return  nums1;


        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
