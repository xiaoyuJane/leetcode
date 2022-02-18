package leetcode.editor.cn.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class numIslandsBfs {
    public static void main(String[] args) {
        Solution solution = new numIslandsBfs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i=0;i<grid.length;i++){
                for (int j=0;j<grid[0].length;j++){
                    if (grid[i][j] == '1'){
                        count++;
                        bfs(grid,i,j);
                    }
                }
            }
            return count;  
        }

        private void bfs(char[][] grid, int x, int y) {
            grid[x][y] = '0';
            int n = grid.length;
            int m = grid[0].length;
            Queue<Integer> queue = new LinkedList<>();
            int code = x*m+y;
            queue.offer(code);

            while (!queue.isEmpty()){
                code = queue.poll();
                int i=code/m;
                int j=code%m;
                if (i > 0 && grid[i - 1][j] == '1') {//上 如果上边格子为1，把它置为0，然后加入到队列中
                    //下面同理
                    grid[i - 1][j] = '0';
                    queue.add((i - 1) * m + j);
                }
                if (i < n - 1 && grid[i + 1][j] == '1') {//下
                    grid[i + 1][j] = '0';
                    queue.add((i + 1) * m + j);
                }
                if (j > 0 && grid[i][j - 1] == '1') { //左
                    grid[i][j - 1] = '0';
                    queue.add(i * m + j - 1);
                }
                if (j < m - 1 && grid[i][j + 1] == '1') {//右
                    grid[i][j + 1] = '0';
                    queue.add(i * m + j + 1);
                }



            }

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
