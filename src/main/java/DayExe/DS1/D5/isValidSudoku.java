package DayExe.DS1.D5;

import java.util.HashSet;

public class isValidSudoku {
    public static void main(String[] args) {
        Solution solution = new isValidSudoku().new Solution();
        char[][] board ={
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};
        System.out.println(solution.isValidSudoku(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //[['.','.','4','.','.','.','6','3','.'],
    // ['.','.','.','.','.','.','.','.','.'],
    // ['5','.','.','.','.','.','.','9','.'],
    // ['.','.','.','5','6','.','.','.','.'],
    // ['4','.','3','.','.','.','.','.','1'],
    // ['.','.','.','7','.','.','.','.','.'],
    // ['.','.','.','5','.','.','.','.','.'],
    // ['.','.','.','.','.','.','.','.','.'],
    // ['.','.','.','.','.','.','.','.','.']]
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                if (!isSatisfy(0,8,i,i,board)) return false;
                if (!isSatisfy(i,i,0,8,board)) return false;

            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <3 ; j++) {
                    if (!isSatisfy(3*i,3*(i+1)-1,3*j,3*(j+1)-1,board)) return false;
                }
            }
            return true;
        }

        /**
         * 判断某一区域内是否出现重复数字
         * @param ix 行起始
         * @param iy 行尾
         * @param jx 列起始
         * @param jy 列尾
         * @param board 原始数组
         * @return
         */
        public boolean isSatisfy(int ix,int iy,int jx,int jy,char[][] board){
            HashSet<Character> set = new HashSet<>(9);
            for (int i = ix; i <=iy ; i++) {
                for (int j = jx; j <= jy; j++) {
                    if (board[i][j]!='.'){
                        if (!set.add(board[i][j])) return false;
                        set.add(board[i][j]);
                    }
                }
            }
            return true;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
