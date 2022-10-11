package DayExe.DS1.D4;

import java.util.Arrays;

public class matrixReshape {
    public static void main(String[] args) {
        Solution solution = new matrixReshape().new Solution();
        int[][] mat = {{1,2},{3,4}};
        int r=3,c=4;
        System.out.println(Arrays.toString(solution.matrixReshape(mat,r,c)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int m = mat.length;
            int n = mat[0].length;
            int sum = m*n;
            if (sum != r*c) return mat;

            int[][] res = new int[r][c];
            //通过数学计算，将sum转为res和mat的下标，
            // 对于sum,其对应的矩阵坐标i=sum[i]/n ,j=sum[i]%n
            for (int i = 0; i < sum; i++) {
                res[i/c][i%c] = mat[i/n][i%n];
            }
            return res;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
}
