package leetcode.editor.cn.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class updateMatrix2 {
    public static void main(String[] args) {
        Solution solution = new updateMatrix2().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] directions = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        /**
         * 就是先找出在 00 边上的所有的 11，然后把这些 11 放到队列里，后续BFS的时候就只关心 11 的值。
         * @param mat
         * @return res
         */
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> queue = new LinkedList<int[]>();
            int m = mat.length;
            int n = mat[0].length;

            int[][] res = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] ==0){
                        //0四周的位置
                        for (int[] direction : directions){
                            int x = i +direction[0];
                            int y = j +direction[1];
                            //0四周的1位置
                            if (x>=0 && x<m && y>=0 && y<n && mat[x][y] == 1 && res[x][y] == 0){
                                res[x][y] =1; //关键点1，始终聚焦res
                                queue.offer(new int[]{x,y});
                            }
                        }
                    }
                }
            }

            while (!queue.isEmpty()){
                int[] cur = queue.poll();
                for (int[]direction : directions){
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    //mat中非0 即1，现在开始处理1位置周边的res值，递推计算
                    if (x >= 0 && x<m && y>=0 && y<n  && mat[x][y] ==1 && res[x][y]==0){
                        res[x][y] = res[cur[0]][cur[1]] +1 ; //关键点2，始终聚焦res，并且能够保证 res[cur[0]][cur[1]值确定了，因为它入队之前就已经算出值了
                        queue.offer(new int[]{x,y});
                    }
                }

            }

            return res;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
