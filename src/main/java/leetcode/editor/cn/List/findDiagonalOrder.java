package leetcode.editor.cn.List;

public class findDiagonalOrder {
    public static void main(String[] args) {
        Solution solution = new findDiagonalOrder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] res = new int[m*n];

            int count = m+n-1; //对角线个数

            int row=0,col=0,index=0;

            for (int i=0;i<count;i++){
                if (i%2==0){
                    //偶数对角线，向上走，属于col递增，row递减少，故边界条件为row>=0 &&col<n
                    while (row>=0 &&col<n){
                        res[index] = mat[row][col];
                        index++;
                        row--;
                        col++;
                    }
                    //列不越界，行+1
                    if (col<n) row++;

                    //列越界，行+2，列-1
                    else {row +=2;col--;}
                }
                else {
                    //奇数对角线，向下走，属于col递减，row递增
                    while (row<m && col>=0){
                        res[index]=mat[row][col];
                        index++;
                        row++;
                        col--;
                    }
                    if (row<m) col++;
                    else {
                        row--;
                        col+=2;
                    }
                }
            }


            return res;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
