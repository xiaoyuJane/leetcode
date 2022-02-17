package leetcode.editor.cn.BFS;


import java.util.LinkedList;
import java.util.Queue;

public class wallsAndGates {
    public static void main(String[] args) {
        Solution solution = new wallsAndGates().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
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

            for (int row = 0;row<rows;row++){
                for (int column=0; column<columns;column++){
                    if (rooms[row][column] == EMPTY) rooms[row][column] = bfs(rooms,row,column);
                }
            }
        }

        private int bfs(int[][] rooms, int startRow, int startCol) {

            int[][]distance = new int[rooms.length][rooms[0].length];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startRow,startCol});

            while (!queue.isEmpty()){
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];
                //遍历四个方向
                for(int[] direction : directions){
                    int r = row + direction[0];
                    int c = col + direction[1];
                    if (!isInArea(rooms,r,c) || rooms[r][c]== WALL ||distance[r][c] !=0)  continue;
                    distance[r][c] = distance[row][col]+1;
                    if (rooms[r][c] == GATE) return distance[r][c];
                    queue.offer(new int[]{r,c});
                }
            }
            return Integer.MAX_VALUE;
        }

        private boolean isInArea(int[][] rooms, int r, int c) {
            return r>=0 && r<rooms.length && c>=0 && c<rooms[0].length;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}