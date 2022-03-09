package leetcode.editor.cn.DS.List;
//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
//
//        不占用额外内存空间能否做到？
//        示例 1:
//
//        给定 matrix =
//        [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]
//        ],
//
//        原地旋转输入矩阵，使其变为:
//        [
//        [7,4,1],
//        [8,5,2],
//        [9,6,3]
//        ]
//        示例 2:
//
//        给定 matrix =
//        [
//        [ 5, 1, 9,11],
//        [ 2, 4, 8,10],
//        [13, 3, 6, 7],
//        [15,14,12,16]
//        ],
//
//        原地旋转输入矩阵，使其变为:
//        [
//        [15,13, 2, 5],
//        [14, 3, 4, 1],
//        [12, 6, 8, 9],
//        [16, 7,10,11]
//        ]

public class rotate {
    public static void main(String[] args) {
        Solution solution = new rotate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public void rotate(int[][] matrix) {
            int len = matrix.length;
            if(len==1) return;

            int maxIdx = len-1;
            //新建一个新数组，直接根据数学推导出的下标进行赋值
            int[][] newMatrix = new int[len][len];
            for(int y=0; y<len; y++){
                for(int x=0; x<len; x++){
                    newMatrix[y][maxIdx-x]=matrix[x][y];
                }
            }
            /* 采用逐个赋值的方法，而不是 matrix=newMatrix。
             *
             * 本题中，java的参数是一个指向源数组的指针，
             * 直接使用 matrix=newMatrix 赋值改变的是参数的指向，
             * 不是传输进去的源数组的指向。所以需要为参数逐个赋值。*/
            for(int y=0; y<len; y++){
                for(int x=0; x<len; x++){
                    matrix[x][y]=newMatrix[x][y];
                }
            }
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
}
