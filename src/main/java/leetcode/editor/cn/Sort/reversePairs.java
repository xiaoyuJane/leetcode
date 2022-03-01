package leetcode.editor.cn.Sort;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 相关标签
 * 树状数组
 * 线段树
 * 数组
 * 二分查找
 * 分治
 * 有序集合
 * 归并排序

 */
public class reversePairs {
    public static void main(String[] args) {
        Solution solution = new reversePairs().new Solution();
        int[] nums = {7,5,6,4};
        System.out.println(solution.reversePairs(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {

            int len = nums.length;
            if (len <=1) return 0;

            //如果原数组不能被改变，那么需要复制一份相同的数组
            int[] copy = new int[len];
            for (int i = 0; i < len; i++) {
                copy[i] = nums[i];
            }

            int[] temp = new int[len];
            return reversePairs(copy,0,len-1,temp);

        }

        /**
         * 分解向下递归获取逆序对总数的过程
         * @param copy
         * @param left
         * @param right
         * @param temp
         * @return
         */
        private int reversePairs(int[] copy, int left, int right, int[] temp) {
            if (left == right) return 0;

            int mid = left+(right-left)/2;
            int leftPairs = reversePairs(copy,left,mid,temp);
            int rightPairs = reversePairs(copy,mid+1,right,temp);

            if (copy[mid] <= copy[mid+1]) return leftPairs + rightPairs;
            
            int crossPairs = mergeAndCount(copy,left,mid,right,temp);
            return leftPairs + rightPairs + crossPairs;

        }

        /**
         * 合并并计算逆序对的过程
         * @param copy
         * @param left
         * @param mid
         * @param right
         * @param temp
         * @return
         */
        private int mergeAndCount(int[] copy, int left, int mid, int right, int[] temp) {
            for (int i = left; i <=right ; i++) {
                temp[i] = copy[i];
            }

            int i = left, j=mid+1;
            int count =0;

            for (int k = left; k <= right; k++) {
                if (i == mid+1)  copy[k] = temp[j++];
                else if (j == right+1) copy[k] = temp[i++];
                else if (temp[i] <= temp[j]) copy[k] = temp[i++];
                else { //利用了局部有序的概念，如果第一个值就大于后面数组的值，那么比第一个值大的数肯定也大于后面数组的值
                    copy[k] = temp[j++];
                    count += (mid-i+1);
                }
            }

            return count;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
