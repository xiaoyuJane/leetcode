package DayExe.DS2.D4;

public class searchMatrix {
    public static void main(String[] args) {
        Solution solution = new searchMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int k=n,l=m;


            //1.找到搜索矩阵的子矩阵
            for (int i = 0; i <n; i++) {
                if (matrix[0][i]==target) return true;
                if (matrix[0][i]>target) {
                    k=i;
                    break;
                }
            }

            for (int j = 0; j < m; j++) {
                if (matrix[j][0]==target) return true;
                if (matrix[j][0]>target) {
                    l=j;
                    break;
                }
            }

            //2.对子矩阵进行遍历
            for (int i = 0; i <k; i++) {
                if (matrix[l][i] == target) return true;
            }
            for (int j = l-1; j >=0; j--) {
                if (matrix[j][k] == target) return true;
                if (matrix[j][k] < target) break;
            }

            return false;
        }

        //类比二分查找法，线性时间复杂度
        public boolean searchMatrix2(int[][] matrix, int target){

            int j = matrix[0].length-1;
            int i = 0; //从右上角开始遍历

            while (j>=0 && i<=matrix.length-1){
                if ( target == matrix[i][j]) return true;
                if (target < matrix[i][j]) j--;
                else i++;
            }
            return false;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
