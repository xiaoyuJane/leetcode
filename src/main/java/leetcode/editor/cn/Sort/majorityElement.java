package leetcode.editor.cn.Sort;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

 */
public class majorityElement {
    public static void main(String[] args) {
        Solution solution = new majorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //对数组进行排序，众数一定会出现在中间数处
        public int majorityElement(int[] nums) {
            int n = nums.length;
            sort(nums,0,n-1);
            return nums[n/2];

        }

        private void sort(int[] nums, int start, int end) {
            if (start >= end) return;
            int index = partion(nums,start,end);
            sort(nums,start,index-1);
            sort(nums,index+1,end);
        }


        private int partion(int[] nums, int start, int end) {
            int p = nums[start];
            int i= start+1, j = end;

            while (i<j){
                while (i<j && nums[i]<=p) i++;
                if (i!=j){
                    swap(nums,i,j);
                    j--; //j位置被占
                }
            }

            if (i == j && nums[j]>p) j--;
            if (j!=start) swap(nums,start,j);
            return j;
        }

        private void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
