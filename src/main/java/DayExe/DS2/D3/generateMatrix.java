package DayExe.DS2.D3;

public class generateMatrix {
    public static void main(String[] args) {
        Solution solution = new generateMatrix().new Solution();
        int[][] ints = solution.generateMatrix(3);
        System.out.println(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int num = 1;
            //定义四个边界值
            int up=0,down=n-1;
            int left=0,right=n-1;


            while (num<= n*n){
                //从左往右
                for (int j = left; j <=right; j++) {
                    res[up][j] = num++;
                }
                //更新上边界
                up++;

                //从上往下
                for (int i = up; i <= down; i++) {
                    res[i][right] = num++;
                }
                //更新右边界
                right--;


                //从右往左
                for (int j = right; j>=left; j--) {
                    res[down][j]=num++;
                }
                //更新下边界
                down--;

                //从下往上
                for (int i = down; i >=up ; i--) {
                    res[i][left]=num++;
                }
                //更新左边界
                left++;
            }

            return res;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
