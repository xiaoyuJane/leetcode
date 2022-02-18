package leetcode.editor.cn.BFS;


//给你一个整数数组 nums 和一个整数 target 。
//
//        向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//        例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//        返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//        示例 1：
//
//        输入：nums = [1,1,1,1,1], target = 3
//        输出：5
//        解释：一共有 5 种方法让最终目标和为 3 。
//        -1 + 1 + 1 + 1 + 1 = 3
//        +1 - 1 + 1 + 1 + 1 = 3
//        +1 + 1 - 1 + 1 + 1 = 3
//        +1 + 1 + 1 - 1 + 1 = 3
//        +1 + 1 + 1 + 1 - 1 = 3
//        示例 2：
//
//        输入：nums = [1], target = 1
//        输出：1
//         
//
//        提示：
//
//        1 <= nums.length <= 20
//        0 <= nums[i] <= 1000
//        0 <= sum(nums[i]) <= 1000
//        -1000 <= target <= 1000

//        相关标签
//        数组
//        动态规划
//        回溯


public class findTargetSumWays {
    public static void main(String[] args) {
        Solution solution = new findTargetSumWays().new Solution();
        int[] nums = {1,1,1,1,1};
        System.out.println(solution.findTargetSumWays(nums,3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //维护一个静态遍历的计数器，满足则累加
        private int count = 0;

        public int findTargetSumWays(int[] nums, int target) {

            dfs(nums,target,0,0);
            return count;
        }

        private void dfs(int[] nums, int target, int index, int sum){
            //终止条件
            if (index == nums.length) { //遍历完数组了，即index指向了数组溢出的那个位置
                if (target == sum) count++;
                return;
            }

            dfs(nums,target,index+1,sum+nums[index]);
            dfs(nums,target,index+1,sum-nums[index]);

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
