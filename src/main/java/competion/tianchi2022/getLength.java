package competion.tianchi2022;

public class getLength {
    public static void main(String[] args) {
        Solution solution = new getLength().new Solution();
        String[] grid ={"R.",".."};
        System.out.println(solution.getLength(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getLength(String[] grid) {

            char[][] res = trans(grid);
            return getLength(res,0,0,"down");

        }

        //从i和j位置起始进入
        private int getLength(char[][] grid,int i,int j,String dir){
            int m = grid.length;
            int n = grid[0].length;

            if (i>= m || i<0 ||j>=n ||j<0) return 0;
            if (grid[i][j] == '.' && dir.equals("down")) return getLength(grid,i+1,j,"down")+1;
            if (grid[i][j] == '.' && dir.equals("up")) return getLength(grid,i-1,j,"up")+1;
            if (grid[i][j] == '.' && dir.equals("right")) return getLength(grid,i,j+1,"right")+1;
            if (grid[i][j] == '.' && dir.equals("left")) return getLength(grid,i,j-1,"left")+1;

            if (grid[i][j] == 'L' && dir.equals("down")) return getLength(grid,i,j+1,"right")+1;
            if (grid[i][j] == 'L' && dir.equals("up")) return getLength(grid,i,j-1,"left")+1;
            if (grid[i][j] == 'L' && dir.equals("right")) return getLength(grid,i+1,j,"down")+1;
            if (grid[i][j] == 'L' && dir.equals("left")) return getLength(grid,i-1,j,"up")+1;

            if (grid[i][j] == 'R' && dir.equals("down")) return getLength(grid,i,j-1,"left")+1;
            if (grid[i][j] == 'R' && dir.equals("up")) return getLength(grid,i,j+1,"right")+1;
            if (grid[i][j] == 'R' && dir.equals("right")) return getLength(grid,i-1,j,"up")+1;
//            if (grid[i][j] == 'R' && dir.equals("left"))
            else     return getLength(grid,i+1,j,"down")+1;
        }

        private char[][] trans(String[] grid){
            int m = grid.length;
            int n = grid[0].length();
            char[][] res = new char[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = grid[i].charAt(j);
                }
            }
            return res;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
