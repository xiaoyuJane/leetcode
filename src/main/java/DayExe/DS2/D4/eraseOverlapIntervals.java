package DayExe.DS2.D4;

import java.util.Arrays;

public class eraseOverlapIntervals {
    public static void main(String[] args) {
        Solution solution = new eraseOverlapIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划--会超时
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            //对右节点按照升序排序
            Arrays.sort(intervals,((o1, o2) -> o1[1]-o2[1]));
            int n = intervals.length;
            int[] f = new int[n];

            Arrays.fill(f, 1);

            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    //不重叠
                    if (intervals[j][1] <= intervals[i][0]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
            }
            return n - Arrays.stream(f).max().getAsInt();


        }

        //贪心
        public int eraseOverlapIntervals1(int[][] intervals){
            if (intervals.length == 0) {
                return 0;
            }
            //按尾部排序
            Arrays.sort(intervals, ((o1, o2) -> o1[1]-o2[1]));

            int n = intervals.length;
            int right = intervals[0][1];
            int ans = 1;
            //遍历数组，如果后一个区间的左边界比前一个区间的右边界还大，说明没有交集，更新右边界值
            for (int i = 1; i < n; ++i) {
                if (intervals[i][0] >= right) {
                    ++ans;
                    right = intervals[i][1];
                }
            }
            //最小的移除数量=n-最大的不相交区间数
            return n - ans;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
