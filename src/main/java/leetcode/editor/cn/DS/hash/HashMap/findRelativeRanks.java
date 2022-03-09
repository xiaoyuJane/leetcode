package leetcode.editor.cn.DS.hash.HashMap;

import java.util.Arrays;
import java.util.HashMap;

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
        /**
         * copy数组从高到低排序
         * map记录了得分和排名index的映射
         * res为string数组，用于结果输出
         * score为原始得分数组
         * 比较score与copy的前三名分值，命中的话给res赋值map对应的index下标
         * @param score
         * @return
         */
        public String[] findRelativeRanks(int[] score) {
            int[] copy = score.clone();
            sort(copy); //做降序排序
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < copy.length; i++) {
                map.put(copy[i],i+1);
            }
            //Java 8 Stream API将int数组转换为String数组
            String[]res = Arrays.stream(score).mapToObj(String::valueOf).toArray(String[]::new);


            for (int i = 0; i < score.length; i++) {
                if (score[i] == copy[0]) res[i] = "Gold Medal";
                else if (score[i] == copy[1]) res[i] = "Silver Medal";
                else if (score[i] == copy[2]) res[i] = "Bronze Medal";
                else res[i] = String.valueOf(map.get(score[i]));
            }
            return res;
        }

        private void sort(int[] copy) {
            int length = copy.length;
            for (int gap = length/2; gap > 0; gap/=2){
                for (int i = gap; i < length; i++) { //由于是从后往前比较，所以前面预留0~gap之间刚好gap个数据用来存放最小（大）值
                    int tmp = copy[i];
                    int p = i-gap;
                    while (p>=0 && tmp > copy[p]){
                        copy[p+gap] = copy[p];
                        p -=gap;
                    }
                    copy[p+gap] = tmp;

                }
            }
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
