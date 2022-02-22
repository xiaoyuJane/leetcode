package leetcode.editor.cn.List;
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//         
//
//        示例 1：
//
//        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出：[[1,6],[8,10],[15,18]]
//        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//        示例 2：
//
//        输入：intervals = [[1,4],[4,5]]
//        输出：[[1,5]]
//        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//         
//
//        提示：
//
//        1 <= intervals.length <= 104
//        intervals[i].length == 2
//        0 <= starti <= endi <= 104
//        相关标签
//        数组
//        排序


import java.util.*;

public class merge {
    public static void main(String[] args) {
        Solution solution = new merge().new Solution();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res = solution.merge(intervals);
        for (int[] re: res
             ) {
            for (int r:re)
            System.out.println(r);

        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //本题需要理解题意
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]); //将区间集合以起始位置递增排序

            int[][] res = new int[intervals.length][2]; //要理解是用两位长度的数组表示集合
            int res_index = -1;

            for (int[] interval : intervals){
                //初始时，res_index == -1，所以是直接是res[0]=interval
                //后面就是判断第二个集合的第一位与第一个集合的末位的关系，如果始位大于末位，表示无交集，继续放进res即可
                if (res_index == -1 || interval[0] > res[res_index][1]) res[++res_index] = interval;
                //如果始位小于或等于末位，表明有交集，取两个集合中末位最大值即可
                else res[res_index][1] = Math.max(res[res_index][1],interval[1]);
            }

            //需要完成拷贝，因为结果集的长度不是res定义中的intervals.length
            return Arrays.copyOf(res,res_index+1);



        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
