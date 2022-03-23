package leetcode.editor.cn;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
// 返回 滑动窗口中的最大值 。 
//
// 示例 1： 
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
// 提示：
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1468 👎 0


//单调队列从字面上看，无非就是有某种单调性的队列.
// 不断地向缓存数组里读入元素，也不时地去掉最老的元素，不定期的询问当前缓存数组里的最小的元素
// 单调队列它分两种:
// 1. 单调递增的
// 2. 单调递减的
// 应用场景：一般都是需要得到当前的某个范围内的最小值或最大值
// 每个窗口前进的时候，要添加一个数同时减少一个数，所以想在 O(1) 的时间得出新的最值，就需要「单调队列」这种特殊的数据结构来辅助了

import java.util.*;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = {7,2,4};
        int k = 2;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums,k)));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //要求最大值，就需要构造单调递减队列
        // 会发现为了满足单调递减的条件，需要不断调整单调队列弹出队尾，所以用的肯定是双端队列
        // 单调队列的队首是当前队列最大值，后面的都是“候选”的最大值，一旦当前最大值在存数据的队列中被移出了，那么“候选”的最大值马上上位。
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length+1-k];
        Queue<Integer> max = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            //构建单调递减，保持队首为最大值
//            if (max.size()>=k) max.poll();
            while (!max.isEmpty() && curr >= nums[max.peek()]){
                max.poll();
            }
            //直到队尾为不小于curr，curr可以入队
            max.offer(i);
            if (max.peek() <= i-k) max.poll();
           if (i>=k-1){
               res[i-k+1] = nums[max.peek()];
           }
        }


        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}