package leetcode.editor.cn.hash.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) {
        Solution solution = new twoSum().new Solution();
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(solution.twoSum(nums,target)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // HashMap 的典型应用思路

        public int[] twoSum(int[] nums, int target) {
            /**
             *
             *     Map<Type, InfoType> hashmap = new HashMap<>();
             *     for (Type key : keys) {
             *         if (hashmap.containsKey(key)) {
             *             if (hashmap.get(key) satisfies the requirement) {
             *                 return needed_information;
             *             }
             *         }
             *         // Value can be any information you needed (e.g. index)
             *         hashmap.put(key, value);
             *     }
             *     return needed_information;
             */
            Map<Integer,Integer> map = new HashMap<>();
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                //寻找目标元素，如果目标元素存在，表示与当前元素匹配
                int a = target-nums[i];
                if (map.containsKey(a)){
                    return new int[]{i,map.get(a)};
                }
                map.put(nums[i],i);
            }
            return new int[0];
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
