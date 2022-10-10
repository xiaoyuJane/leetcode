package DayExe.DS2.D3;

public class rotate {
    public static void main(String[] args) {
        Solution solution = new rotate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //数学法
        public void rotate(int[][] matrix) {

            int n = matrix.length;
            int[][] res = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][n-i-1]=matrix[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = res[i][j];
                }

            }

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
