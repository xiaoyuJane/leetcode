package competion.single.c314;

import java.util.ArrayList;
import java.util.List;

public class numberOfPaths {
    public static void main(String[] args) {
        Solution solution = new numberOfPaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int numberOfPaths(int[][] grid, int k) {
            List<Integer> res = dfs(grid, grid.length , grid[0].length );
            int count = 0;
            for (Integer re : res) {
                if (re%k == 0) count++;
            }

            return count;

        }

        private List<Integer> dfs(int[][]grid, int m, int n){

            ArrayList<Integer> ans = new ArrayList<>();
            if (m ==1 && n==1)  ans.add(grid[0][0]);
            else if (m ==1){
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum+=grid[0][i];
                }
                ans.add(sum);
            }
            else if (n ==1 ){
                int sum = 0;
                for (int i = 0; i < m; i++) {
                    sum+=grid[i][0];
                }
                ans.add(sum);
            }else {
                for (Integer sum : dfs(grid, m - 1, n)) {
                    ans.add(sum+grid[m-1][n-1]);
                }
                for (Integer sum : dfs(grid, m, n - 1)) {
                    ans.add(sum+grid[m-1][n-1]);
                }
            }


            return ans;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
