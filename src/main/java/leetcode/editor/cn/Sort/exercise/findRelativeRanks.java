package leetcode.editor.cn.Sort.exercise;

import java.util.Arrays;

/**
 * 506. 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *  
 * 示例 1：
 *
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 示例 2：
 *
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 * 提示：
 *
 * n == score.length
 * 1 <= n <= 104
 * 0 <= score[i] <= 106
 * score 中的所有值 互不相同
 * 相关标签
 * 数组
 * 排序
 * 堆（优先队列）
 */
public class findRelativeRanks {
    public static void main(String[] args) {
        Solution solution = new findRelativeRanks().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            int n = score.length;
            String[] desc = {"Gold Medal","Silver Medal","Bronze Medal"};

            //构建二维数组，i为输出的既定顺序，必须保存下来
            int[][] arr = new int[n][2];
            for (int i = 0; i < n ; i++) {
                arr[i][0] = score[i];
                arr[i][1] = i;
            }

            Arrays.sort(arr,(a,b)->b[0]-a[0]); //按照第一维度降序排列
            String[] res = new String[n];
            for (int i = 0; i < n; i++) { //由于arr是按照第一维度降序，所以i从0到n是第一名到第n名
                if (i>=3) res[arr[i][1]] = Integer.toString(i+1); //arr[i][1] 对应着第一名原来的下标
                else res[arr[i][1]] = desc[i];
            }

            return res;




        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
