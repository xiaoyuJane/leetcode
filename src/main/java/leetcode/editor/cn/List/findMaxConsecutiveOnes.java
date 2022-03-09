package leetcode.editor.cn.List;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 *
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 * 相关标签
 * 数组
 */

//贪心算法

public class findMaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new findMaxConsecutiveOnes().new Solution();
        int[] nums = {1,0,1,1,0,0,1,1,1,1};
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int res =0;  //最大连续1的个数
            int tmp =0; //连续1的个数

            for (int i=0;i<nums.length;i++){
                if (nums[i]==1) tmp++;
                else tmp = 0; //1中断就重新开始计数

                res = Math.max(res,tmp); //额外的变量用来保存整个遍历过程中的最大值，相当于做了状态存储
            }
            return Math.max(res,tmp);

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
