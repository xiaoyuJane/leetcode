package leetcode.editor.cn.List;

import java.util.HashSet;
import java.util.Set;

public class setZeroes {
    public static void main(String[] args) {
        Solution solution = new setZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> xs = new HashSet<Integer>();
            Set<Integer> ys = new HashSet<Integer>();

            for (int i=0;i<matrix.length;i++){
                for (int j=0;j<matrix[0].length;j++){
                    if (matrix[i][j] == 0){
                        xs.add(i);
                        ys.add(j);
                    }
                }
            }

            for (Integer x:xs){
                for (int j=0;j<matrix[0].length;j++){
                    matrix[x][j] = 0;
                }
            }

            for (Integer y:ys){
                for (int i=0;i<matrix.length;i++){
                    matrix[i][y] = 0;
                }
            }
        }


        //官方题解--使用标记数组
//        时间复杂度：O(mn)O(mn)，其中 mm 是矩阵的行数，nn 是矩阵的列数。我们至多只需要遍历该矩阵两次。
//        空间复杂度：O(m+n)O(m+n)，其中 mm 是矩阵的行数，nn 是矩阵的列数。我们需要分别记录每一行或每一列是否有零出现。
        public void setZeroes1(int[][] matrix){
            int m = matrix.length, n = matrix[0].length;

            //用两个标记数组分别记录每一行和每一列是否有零出现
            boolean[] row = new boolean[m];
            boolean[] col = new boolean[n];
            //我们首先遍历该数组一次，如果某个元素为 00，那么就将该元素所在的行和列所对应标记数组的位置置为 true
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = col[j] = true;
                    }
                }
            }
            //我们再次遍历该数组，用标记数组更新原数组即可
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }




    }

        //官方题解--使用两个标记变量

        /**O(1) 的额外空间
         * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1)O(1) 的额外空间。
         * 但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 00。
         * 因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 00。
         * @param matrix
         */
        public void setZeroes2(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean flagCol0 = false, flagRow0 = false;

            //第一列单独处理
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    flagCol0 = true;
                }
            }

            //第一行单独处理
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    flagRow0 = true;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (flagCol0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (flagRow0) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }

        }






        }

//leetcode submit region begin(Prohibit modification and deletion)
}
