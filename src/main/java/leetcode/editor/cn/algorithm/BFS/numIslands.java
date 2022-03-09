package leetcode.editor.cn.algorithm.BFS;


import java.util.LinkedList;
import java.util.Queue;

public class numIslands {
    public static void main(String[] args) {
        Solution solution = new numIslands().new Solution();
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int result = solution.numIslands(grid);
        System.out.println(result);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static final char ISLAND = '1';
        public static final char WATER = '0';
        public static final char USED = '2';
        private int[][] directions = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };


        public int numIslands(char[][] grid) {
            int counts = 0;
            int rows = grid.length;
            int cols = grid[0].length;

            Queue<int[]> queue = new LinkedList<>();

            for (int row = 0;row<rows;row++) {
                for (int col = 0; col < cols; col++) {
                    while (grid[row][col] != USED && grid[row][col]!=WATER){
                        queue.offer(new int[]{row, col});
                        grid[row][col] = USED;

                        while (!queue.isEmpty()) {
                            int[] point = queue.poll();
                            int row_index = point[0];
                            int col_index = point[1];
                            for (int[] direction :directions){
                                int row_next = row_index +direction[0];
                                int col_next = col_index +direction[1];
                                //===核心点在这里，什么情况下不需要入队，用continue跳出循环
                                if ( row_next <0 || col_next <0 ||row_next >=rows || col_next >=cols ||grid[row_next][col_next] == WATER || grid[row_next][col_next] == USED) continue;
                               // ===核心点end
                                queue.offer(new int[]{row_next,col_next});
                                grid[row_next][col_next] = USED;

                            }
                        }
                        counts++;
                    }
                }
            }


            return counts;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}

