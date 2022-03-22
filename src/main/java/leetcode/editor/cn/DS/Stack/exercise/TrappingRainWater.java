package leetcode.editor.cn.DS.Stack.exercise;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
// 示例 1：
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
//
// 示例 2： 
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
// 提示： 
// n == height.length
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 3229 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] height = {4,2,0,3,2,5};
        System.out.println(solution.trap(height));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //暴力解法
    public int trap(int[] height){
        return  0;
    }

    //栈解法
    public int trap1(int[] height) {
        int sum = 0;
        //使用栈来存储条形块的索引下标。
        Deque<Integer> stack = new ArrayDeque<>();

        //遍历数组
        for (int i = 0; i < height.length; i++) {
            //当栈非空且height[i] > height[stack.peek()]
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty()) break;
                //计算当前元素和栈顶元素的距离，准备进行填充操作
                int dis = i - stack.peek() -1;
                //找出界定高度
                int min_height  = Math.min(height[i],height[stack.peek()])-height[top];
                //往答案中累加积水量
                sum += dis * min_height;
            }
            stack.push(i);
        }


        return sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}