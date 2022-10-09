package DayExe.DS2.D2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {
    public static void main(String[] args) {
        Solution solution = new merge().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,((o1, o2) -> o1[0]-o2[0]));
            ArrayList<int[]> lists = new ArrayList<>();

            int[] item = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0]<=item[1]) {
                    item = new int[]{Math.min(item[0],intervals[i][0]),Math.max(item[1],intervals[i][1]) };
                }else {
                    lists.add(item);
                    item = intervals[i];
                }
            }
            lists.add(item);

            int[][] res = new int[lists.size()][];
            for (int i = 0; i < lists.size(); i++) {
                res[i] = lists.get(i);
            }
            return res;


        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
