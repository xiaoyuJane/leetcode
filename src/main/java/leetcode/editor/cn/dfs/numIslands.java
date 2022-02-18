package leetcode.editor.cn.dfs;

public class numIslands {
    public static void main(String[] args) {
        Solution solution = new numIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i=0;i<grid.length;i++){
                for (int j=0;j<grid[0].length;j++){
                    if (grid[i][j] == '1'){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }
            return count;

        }

        private void dfs(char[][] grid, int i, int j) {
            //边界条件
            if (i<0 || i>=grid.length ||j<0 ||j>=grid[0].length ||grid[i][j] == '0') return;

            grid[i][j] = '0';
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
