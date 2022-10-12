package DayExe.DS2.D5;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 *  
 *
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 */
public class productExceptSelf {
    public static void main(String[] args) {
        Solution solution = new productExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //常规思路，分为左右两部分，将可能用到的结果都记录在数组中
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];

            int[] left = new int[n];
            left[0]=1;
            for (int i = 0; i < n-1; i++) {
                left[i+1]=left[i]*nums[i];
            }

            int[] right = new int[n];
            right[n-1]=1;
            for (int j = n-1; j>0;j--){
                right[j-1] = right[j] * nums[j];
            }

            for (int i = 0; i < n; i++) {
                res[i] = left[i]*right[i];
            }
            return res;


        }
        //考虑使用一个元素空间来处理
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
