package competion.single.c313;

public class maxSum {
    public static void main(String[] args) {
        Solution solution = new maxSum().new Solution();
//        grid = [[1,2,3],[4,5,6],[7,8,9]]
        int[][] grid = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
        System.out.println(solution.maxSum(grid));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSum(int[][] grid) {
            int res = 0;
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i <=m-3 ; i++) {
                for (int j = 0; j <= n-3; j++) {
                    res = Math.max(res,getSum(grid,i,j));
                }
            }
            return res;
        }

        private int getSum(int[][] grid,int i,int j){
            int sum = 0;
            for (int k = i; k < i+3; k++) {
                for (int l = j; l < j+3; l++) {
                    sum+=grid[k][l];
                }
            }
            sum = sum - grid[i+1][j] -grid[i+1][j+2];
            return sum;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
