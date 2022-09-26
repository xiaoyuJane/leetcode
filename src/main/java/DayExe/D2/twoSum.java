package DayExe.D2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) {
        Solution solution = new twoSum().new Solution();
        int[] nums ={2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum2(nums, target)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //1.暴力方法
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int t = target- nums[i];
                for (int j = 0; j < nums.length; j++) {
                    if (i!=j && t==nums[j]) {
                        res[0]=i;
                        res[1]=j;
                    }

                }
            }
            return res;
        }

        //改进版：
        public int[] twoSum3(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                //如果遍历的话，从第一个开始遍历,i+1位置肯定会被之前的i个位置遍历过，
                // 所以只需要关注i+1之后的位置即可了，这里j从i+1处开始
                for (int j = i+1; j < nums.length; j++) {
                    if ( nums[i] + nums[j] == target) { //没必要新建空间t
                        //直接返回数组
                       return new int[]{i,j};
                    }

                }
            }
            return new int[0]; //不满足的情况下，返回空数组
        }

        //2.进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？使用哈希表
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; ++i) {
                //已在过，直接返回下标和当前下标的组合即可
                if (hashtable.containsKey(target - nums[i])) {
                    return new int[]{hashtable.get(target - nums[i]), i};
                }
                //顺序不能改，先判断，再入库
                // 遍历的过程中做存取操作
                hashtable.put(nums[i], i);
            }
            return new int[0];
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
