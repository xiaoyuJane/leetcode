package leetcode.editor.cn.Sort.exercise;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 * 相关标签
 * 数组
 * 双指针
 * 排序
 */
public class merge {
    public static void main(String[] args) {
        Solution solution = new merge().new Solution();
        int[] A = {4,5,6,0,0,0};
        int[] B = {1,2,3};
        solution.merge1(A,3,B,3);
        System.out.println(Arrays.toString(A));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int i =0,j=0;
            while (i<m+j &&j<n){
                if (A[i]<=B[j]) {
                    i++;
                }
                else {
                    //后移操作==
                    int k = A.length-1;
                    while (k>i){
                        A[k]=A[k-1];
                        k--;
                    }
                    //后移操作==
                    A[i] = B[j];
                    i++;
                    j++;
                }
            }

            while (j<n) {
                A[i++] = B[j++];
            }

        }


        //官方解法，逆向合并
        public void merge1(int[] A, int m, int[] B, int n){
            int i=m-1,j=n-1;
            int tail = m+n-1;

            int tmp;
            while (i>=0 ||j>=0 ){
                if (i == -1) tmp = B[j--]; //A遍历完了，拿B赋值
                else if (j == -1) tmp = A[i--]; //B遍历完了，拿A赋值
                else if (A[i]>B[j]) tmp=A[i--];  //取最大值
                else tmp = B[j--];
                A[tail--] = tmp;

            }
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
