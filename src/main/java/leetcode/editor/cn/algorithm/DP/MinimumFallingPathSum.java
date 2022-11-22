package leetcode.editor.cn.algorithm.DP;

//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 201 👎 0

public class MinimumFallingPathSum{
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n]; //位置为i,j到最底层的最小和
        
        //base case
        for (int i = 0; i < n; i++) {
            dp[n-1][i]=matrix[n-1][i];
        }
        
        //从第一行开始遍历
        for (int i = n-2; i >=0; i--) {
            for (int j = 0; j < n; j++) {
                if (j==0 ){
                    dp[i][j]=Math.min(dp[i+1][j]+matrix[i][j],dp[i+1][j+1]+matrix[i][j]);
                }else if (j==n-1){
                    dp[i][j]=Math.min(dp[i+1][j]+matrix[i][j],dp[i+1][j-1]+matrix[i][j]);
                }else{
                    int tmp1 =Math.min(dp[i+1][j-1]+matrix[i][j],dp[i+1][j]+matrix[i][j]);
                    dp[i][j]=Math.min(tmp1,dp[i+1][j+1]+matrix[i][j]);
                }
            }
        }

        int res = dp[0][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res,dp[0][i]);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}