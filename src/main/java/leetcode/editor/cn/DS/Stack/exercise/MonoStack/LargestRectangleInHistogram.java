package leetcode.editor.cn.DS.Stack.exercise.MonoStack;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1816 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //求最值，暴力解法就是遍历每个高度，构造最大面积
        // 当前的数字可以向两边拓展，遇到比自己大的就接着拓展，小的就停止
        // 然后用自己的高度乘以拓展的宽度，每次都更新最大面积
    public int largestRectangleArea1(int[] heights) {
        int res = 0;

        for (int i = 0; i < heights.length; i++){
            int left = i;
            int right = i;
            int height = heights[i];

            //向左延伸
            while (left > 0 && heights[left-1] >= height) left--;
            //向右延伸
            while (right<heights.length-1 && heights[right+1] > height) right++;

            res = Math.max(res,height*(right-left+1));
        }
        return res;
    }

    // 栈解法：构造单调递减栈
    // 1.设置一个单调递减的栈（栈内0~n为单调递增）
    // 2.当遇到小于栈顶元素的值，我们开始更新数据，因为有可能最大面积就会出现在栈中的序列里
    // 3.牢记栈中数据永远是有序的

    public int largestRectangleArea(int[] heights){
        if (heights.length == 1) return heights[0];

        int res = 0;
        int top = 0;

        int[] nums = Arrays.copyOf(heights,heights.length+1);
        nums[heights.length] = -1;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (stack.isEmpty() || curr >= nums[stack.peek()]) stack.push(i);
            else {
                //遇到比栈顶元素小的情况，做更新处理
                while (!stack.isEmpty() && curr < nums[stack.peek()]){
                    top = stack.pop();
                    res = Math.max(res,nums[top]*(i-top));
                }
                //做下特殊的处理,因为这里遍历完了while循环，找到了最左侧比他大的数，将其截断成和它一样长
                stack.push(top);
                nums[top] = nums[i];
            }

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}