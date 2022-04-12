package leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 5308 👎 0


//合并两个有序数组，归并排序
public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1,nums2));

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        dfs(nums1,nums2,nums,0,0,0);
        int k = nums.length / 2;

        if (nums.length%2 == 0){
           return (nums[k]+nums[k-1])/2.0;
        }else return nums[k];

    }

    private void dfs(int[] nums1, int[] nums2, int[]nums, int k, int l, int m){
        if (k>= nums1.length){
            while (m<nums.length)
            nums[m++]=nums2[l++];
            return;

        }else if (l >= nums2.length) {
            while (m<nums.length)
            nums[m++]=nums1[k++];
            return;
        }

        if (nums1[k]<= nums2[l]) nums[m++]=nums1[k++];
        else nums[m++]=nums2[l++];

        dfs(nums1,nums2,nums,k,l,m);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}