package leetcode.editor.cn.algorithm.BFS;


import java.util.LinkedList;
import java.util.Queue;

public class wallsAndGates2 {
    public static void main(String[] args) {
        Solution solution = new wallsAndGates2().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 以门入队列，探索门到各空房间的解
     */
    class Solution {
        private static final int EMPTY = Integer.MAX_VALUE;
        private static final int GATE = 0;
        public static final int WALL = -1;

        private int[][] directions = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };

        public void wallsAndGates(int[][] rooms) {
            int rows = rooms.length;
            int columns = rooms[0].length;
            Queue<int[]> queue = new LinkedList<>();


            for (int row = 0;row<rows;row++){
                for (int column=0; column<columns;column++){
                    if (rooms[row][column] == GATE)  queue.offer(new int[]{row,column});
                }
            }

            while (!queue.isEmpty()){
                int[] point = queue.poll();
                int row_index = point[0];
                int col_index = point[1];
                for (int[] direction :directions){
                    int row = row_index +direction[0];
                    int col = col_index +direction[1];
                    //bfs也有边界条件的，即入队的时机
                    if (row <0 || col<0 || row >= rows || col>= columns || rooms[row][col] != EMPTY) continue;

                    rooms[row][col] = rooms[row_index][col_index] +1;
                    queue.offer(new int[]{row,col});
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}