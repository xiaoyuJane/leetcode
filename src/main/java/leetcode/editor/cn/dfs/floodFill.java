package leetcode.editor.cn.dfs;
//图像渲染
//        有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
//
//        给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
//
//        为了完成上色工作，
//        从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
//        接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
//
//        最后返回经过上色渲染后的图像。
//
//        示例 1:
//
//        输入:
//        image = [[1,1,1],[1,1,0],[1,0,1]]
//        sr = 1, sc = 1, newColor = 2
//        输出: [[2,2,2],[2,2,0],[2,0,1]]
//        解析:
//        在图像的正中间，(坐标(sr,sc)=(1,1)),
//        在路径上所有符合条件的像素点的颜色都被更改成2。
//        注意，右下角的像素没有更改为2，
//        因为它不是在上下左右四个方向上与初始点相连的像素点。
//        注意:
//
//        image 和 image[0] 的长度在范围 [1, 50] 内。
//        给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
//        image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
//        相关标签
//        深度优先搜索
//        广度优先搜索
//        数组
//        矩阵


public class floodFill {
    public static void main(String[] args) {
        Solution solution = new floodFill().new Solution();
        int[][] image = new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int[][] res = solution.floodFill(image,1,1,2);
        for (int[] i : res){
            for(int j : i){
                System.out.println(j);
            }
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int color = image[sr][sc];
            dfs(image,sr,sc,color,newColor);
            return image;
        }

        private void dfs(int[][] image,int i,int j,int color,int newColor){
            //边界条件
            if (i<0||i>=image.length||j<0||j>=image[0].length || image[i][j] == newColor) return;

            if (image[i][j] == color) {
                image[i][j] = newColor;
                dfs(image,i-1,j,color,newColor);
                dfs(image,i+1,j,color,newColor);
                dfs(image,i,j-1,color,newColor);
                dfs(image,i,j+1,color,newColor);
            }
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
