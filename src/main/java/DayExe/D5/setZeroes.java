package DayExe.D5;

import java.util.ArrayList;

//matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
public class setZeroes {
    public static void main(String[] args) {
        Solution solution = new setZeroes().new Solution();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes2(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // o(m+n)的空间复杂度
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            ArrayList<Integer> rows = new ArrayList<>();
            ArrayList<Integer> cols = new ArrayList<>();


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0){
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }

            for (Integer row : rows) {
                for (int i = 0; i < n; i++) {
                    matrix[row][i] = 0;
                }
            }

            for (Integer col : cols) {
                for (int i = 0; i < m; i++) {
                    matrix[i][col] = 0;
                }
            }

        }


        //o(1) 原地解法，常量的空间复杂度
        //基本思路，还是先打标记，后按标记置为0，
        // 首先判断第0行第0列是否需要被置为0，
        // 从第一列第一行开始遍历找0，使用第0行第0列作为标记位，
        // 这里的原理是一旦某行踩雷，该行的第0个元素也要被置为0，即命中早或晚都要被置为0，未命中就保持原值
        public void setZeroes2(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean m_flag = false;
            boolean n_flag = false;

            //打标记部分
            for (int i = 0; i < m; i++) {
                if(matrix[i][0] == 0) {
                    m_flag = true;  //该列全为0，应该要matrix[i][0] == 0
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if(matrix[0][j] == 0) {
                    n_flag = true;  //该行全为0
                    break;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0){
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }

            //赋值部分
            for (int i = 1; i <m ; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] ==0 || matrix[0][j] ==0) matrix[i][j] = 0;
                }

            }

            if (m_flag){
                for (int i = 0; i < m; i++) {
                    matrix[i][0]=0;
                }

            }

            if (n_flag){
                for (int j = 0; j < n; j++) {
                    matrix[0][j]=0;
                }
            }
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
