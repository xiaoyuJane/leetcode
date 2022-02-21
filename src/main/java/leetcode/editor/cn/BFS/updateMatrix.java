package leetcode.editor.cn.BFS;
//01 矩阵
//        给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，
//        其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
//        两个相邻元素间的距离为 1 。
//        示例 1：
//
//
//
//        输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//        输出：[[0,0,0],[0,1,0],[0,0,0]]
//        示例 2：
//
//
//
//        输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//        输出：[[0,0,0],[0,1,0],[1,2,1]]
//         
//
//        提示：
//
//        m == mat.length
//        n == mat[i].length
//        1 <= m, n <= 104
//        1 <= m * n <= 104
//        mat[i][j] is either 0 or 1.
//        mat 中至少有一个 0 
//        相关标签
//        广度优先搜索
//        数组
//        动态规划
//        矩阵


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class updateMatrix{
    public static void main(String[] args) {
        Solution solution = new updateMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] directions = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        /**
         * 首先把每个源点 00 入队，然后从各个 00 同时开始一圈一圈的向 11 扩散（每个 11 都是被离它最近的 00 扩散到的 ）
         * @param mat
         * @return
         */
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> queue = new LinkedList<int[]>();
            int m = mat.length;
            int n = mat[0].length;

            for (int i=0;i<m;i++ ){
                for (int j=0;j<n;j++){
                    if (mat[i][j] == 0) queue.offer(new int[]{i,j});  //0入队
                    else mat[i][j] = -1; //非0 置为-1
                }
            }

            while (!queue.isEmpty()){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] direction : directions){
                    int row = r + direction[0];
                    int col = c + direction[1];
                    if (row >=0 && row <m && col >=0 && col <n && mat[row][col] ==-1){
                        mat[row][col] = mat[r][c] +1; //入队的mat（值为0 的）作为基准，用来计算其前后左右的mat的值，并依次蔓延开来，
                        // 将确定的结果入队，直到蔓延到边界外或者是没有为-1的，即表示所有位置都遍历完了
                        queue.offer(new int[]{row,col});
                    }
                }
            }

            return mat;

        }


    }
//leetcode submit region begin(Prohibit modification and deletion)

}

