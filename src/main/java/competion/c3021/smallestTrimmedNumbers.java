package competion.c3021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个下标从 0 开始的字符串数组 nums ，其中每个字符串 长度相等 且只包含数字。
 *
 * 再给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [ki, trimi] 。对于每个 queries[i] ，你需要：
 *
 * 将 nums 中每个数字 裁剪 到剩下 最右边 trimi 个数位。
 * 在裁剪过后的数字中，找到 nums 中第 ki 小数字对应的 下标 。如果两个裁剪后数字一样大，那么下标 更小 的数字视为更小的数字。
 * 将 nums 中每个数字恢复到原本字符串。
 * 请你返回一个长度与 queries 相等的数组 answer，其中 answer[i]是第 i 次查询的结果。
 *
 * 提示：
 *
 * 裁剪到剩下最右边 x 个数位的意思是不断删除最左边的数位，直到剩下 x 个数位。
 * nums 中的字符串可能会有前导 0 。
 *
 *
 *输入：nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
 * 输出：[2,2,1,0]
 * 解释：
 * 1. 裁剪到只剩 1 个数位后，nums = ["2","3","1","4"] 。最小的数字是 1 ，下标为 2 。
 * 2. 裁剪到剩 3 个数位后，nums 没有变化。第 2 小的数字是 251 ，下标为 2 。
 * 3. 裁剪到剩 2 个数位后，nums = ["02","73","51","14"] 。第 4 小的数字是 73 ，下标为 1 。
 * 4. 裁剪到剩 2 个数位后，最小数字是 2 ，下标为 0 。
 *    注意，裁剪后数字 "02" 值为 2 。
 *
 *    输入：nums = ["24","37","96","04"], queries = [[2,1],[2,2]]
 * 输出：[3,0]
 * 解释：
 * 1. 裁剪到剩 1 个数位，nums = ["4","7","6","4"] 。第 2 小的数字是 4 ，下标为 3 。
 *    有两个 4 ，下标为 0 的 4 视为小于下标为 3 的 4 。
 * 2. 裁剪到剩 2 个数位，nums 不变。第二小的数字是 24 ，下标为 0 。
 *
 提示：

 1 <= nums.length <= 100
 1 <= nums[i].length <= 100
 nums[i] 只包含数字。
 所有 nums[i].length 的长度 相同 。
 1 <= queries.length <= 100
 queries[i].length == 2
 1 <= ki <= nums.length
 1 <= trimi <= nums[0].length



 */
public class smallestTrimmedNumbers {
    public static void main(String[] args) {
        Solution solution = new smallestTrimmedNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //todo 使用基数排序,也不要使用暴力方法，观察case可知，截取的会有重复的
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

            int[] res = new int[queries.length];

            return res;

            /** cpp代码
             *  int n = nums.size(), m = nums[0].size();
             *         // vecs[i][j] 表示基数排序第 i 轮中第 j 小的数对应的下标
             *         vector<vector<int>> vecs(m + 1);
             *         for (int i = 0; i < n; i++) vecs[0].push_back(i);
             *         for (int i = 1; i <= m; i++) {
             *             vector<vector<int>> B(10);
             *             // 把第 i - 1 轮的结果，根据 nums 中右数第 i 位数，依次放入桶中
             *             for (int x : vecs[i - 1]) B[nums[x][m - i] - '0'].push_back(x);
             *             // 把每个桶的结果连接起来，成为第 i 轮的结果
             *             for (int j = 0; j < 10; j++) for (int x : B[j]) vecs[i].push_back(x);
             *         }
             *
             *         vector<int> ans;
             *         for (auto &q : queries) ans.push_back(vecs[q[1]][q[0] - 1]);
             *         return ans;
             *
             */

        }




        //专业选手的,内存消耗较少，执行用时较长，但思路简单，代码简洁
        public int[] smallestTrimmedNumbers2(String[] nums, int[][] queries){
            int[] result = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                Integer index[] = new Integer[nums.length], k = nums[0].length() - queries[i][1];

                for (int j = 0; j < nums.length; j++) {
                    index[j] = j;
                }
                Arrays.sort(index, Comparator.comparing(o -> nums[o].substring(k)));

                result[i] = index[queries[i][0] - 1];
            }

            return result;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
