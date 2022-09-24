package competion.c3021;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 *
 * 从 nums 选出 两个 相等的 整数
 * 从 nums 中移除这两个整数，形成一个 数对
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 *
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-number-of-pairs-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */




public class numberOfPairs {
    public static void main(String[] args) {
        Solution solution = new numberOfPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //启示：这是一个数学题，根据题目中给的提示，数组的长度和数组的大小均在100以内，所以不妨使用暴力方法,巧解
        public int[] numberOfPairs(int[] nums) {

            int[] count = new int[101], result = new int[2];

            for (int num : nums) {
                count[num]++;
            }
            for (int i : count) {
                result[0] += i / 2; //answer[0] 是形成的数对数目
                result[1] += i % 2; //answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目
            }
            return result;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
