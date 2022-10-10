package competion.single.c314;

import java.util.Arrays;
import java.util.stream.IntStream;

public class hardestWorker {
    public static void main(String[] args) {
        Solution solution = new hardestWorker().new Solution();
        int[] res = {1,5,2,5};
        System.out.println(solution.getindex(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hardestWorker(int n, int[][] logs) {
            //res下标为员工号，值为任务时长
            int[] res = new int[n];
            res[logs[0][0]]= logs[0][1];

            for (int i = 1; i < logs.length; i++) {
                //一个员工可能干了多个任务，res数组只存最长的任务时长
                res[logs[i][0]] =Math.max(res[logs[i][0]],logs[i][1]-logs[i-1][1]) ;
            }

            //寻找时长最大值的过程
            int max = res[0];
            int ans =0;
            for (int i = 1; i < res.length; i++) {
                if (res[i]>max) {
                    max = res[i];
                    ans = i;
                }
            }
            return ans;



        }

        //单元测试
        public int getindex(int[] res){

            int max = res[0];
            int ans =0;
            for (int i = 1; i < res.length; i++) {
                if (res[i]>max) {
                    max = res[i];
                    ans = i;
                }
            }
            return ans;
        }

        public int hardestWorker1(int n,int[][]logs){
            return logs[IntStream.range(0, logs.length).boxed()
                    .min((o, p) -> logs[o][1] - (o > 0 ? logs[o - 1][1] : 0) == logs[p][1] - (p > 0 ? logs[p - 1][1] : 0)
                            ? logs[o][0] - logs[p][0]
                            : logs[p][1] - (p > 0 ? logs[p - 1][1] : 0) - logs[o][1] + (o > 0 ? logs[o - 1][1] : 0))
                    .get()][0];
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
