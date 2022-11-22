package leetcode.editor.cn.algorithm.DP;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 913 👎 0

public class UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
        int[][] obstacleGrid = {{0,0},{1,2},{0,0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //1 <= m, n <= 100
        //机器人每次只能向下或者向右移动一步
        //base case
        if (m==1 && n==1){
            if (obstacleGrid[m-1][n-1]==0) dp[m-1][n-1]=1;
        }
        else if (m==1){
            //base case
            if (obstacleGrid[m-1][0]==0) dp[m-1][0]=1;

            //递推
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[m-1][i] == 0 )dp[m-1][i] = dp[m-1][i-1];
            }
        }
        else if (n==1){
            //base case
            if (obstacleGrid[0][n-1]==0) dp[0][n-1]=1;
            //递推
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][n-1] ==0) dp[i][n-1]=dp[i-1][n-1];
            }
        }
        else{
            //base case
            if (obstacleGrid[0][0]==0) dp[0][0]=1;
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0]==0) dp[i][0]=dp[i-1][0];
            }
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[0][i]==0) dp[0][i]=dp[0][i-1];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j]==0){
                        dp[i][j] = dp[i-1][j]+dp[i][j-1];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}