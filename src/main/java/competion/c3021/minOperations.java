package competion.c3021;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 给你两个正整数数组 nums 和 numsDivide 。你可以从 nums 中删除任意数目的元素。
 * 请你返回使 nums 中 最小 元素可以整除 numsDivide 中所有元素的 最少 删除次数。如果无法得到这样的元素，返回 -1 。
 * 如果 y % x == 0 ，那么我们说整数 x 整除 y 。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
 * 输出：2
 * 解释：
 * [2,3,2,4,3] 中最小元素是 2 ，它无法整除 numsDivide 中所有元素。
 * 我们从 nums 中删除 2 个大小为 2 的元素，得到 nums = [3,4,3] 。
 * [3,4,3] 中最小元素为 3 ，它可以整除 numsDivide 中所有元素。
 * 可以证明 2 是最少删除次数。
 * 示例 2：
 *
 * 输入：nums = [4,3,6], numsDivide = [8,2,6,10]
 * 输出：-1
 * 解释：
 * 我们想 nums 中的最小元素可以整除 numsDivide 中的所有元素。
 * 没有任何办法可以达到这一目的。
 *
 * 提示：
 *
 * 1 <= nums.length, numsDivide.length <= 10^5
 * 1 <= nums[i], numsDivide[i] <= 10^9

 [2,3,2,4,3]
 [9,6,9,3,15]
 */
public class minOperations {
    public static void main(String[] args) {
        Solution solution = new minOperations().new Solution();
        int[] nums = {2,3,2,4,3};
        int[] numsDivide = {9,6,9,3,15};

        System.out.println(solution.minOperations2(nums,numsDivide));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //超出时间限制，增加剪枝操作
        public int minOperations(int[] nums, int[] numsDivide) {

            //1.对numsDivide做剪枝操作,使用TreeSet进行排序
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < numsDivide.length; i++) {
                set.add(numsDivide[i]);
            }
            int min = set.first();

            //2.因为要对nums数组统计删除的个数，所以这里是对nums数组的遍历，
            // 增加了排序，剪枝 nums[i] <= min以及使用HashSet去重
            Arrays.sort(nums);
            HashSet<Integer> s = new HashSet<>();
            for (int i = 0; i<nums.length && nums[i] <= min;) {
                if (!s.add(nums[i])) i++;
                else if (canDivide(nums[i],set)) return i;
                else i++;

            }
             return -1;
        }

        public boolean canDivide(int num,TreeSet<Integer> set){
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()){
                if ((iterator.next())%num !=0) return false;
            }
            return true;
        }

        //最大公约数
        public int minOperations2(int[] nums, int[] numsDivide) {
            int gcd = 0;
            //求取numsDivide的最大公约数
            for (int num : numsDivide) {
                gcd = BigInteger.valueOf(gcd).gcd(BigInteger.valueOf(num)).intValue();
            }
            //求取nums的最小公约数
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (gcd % nums[i] == 0) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
