package leetcode.editor.cn.DS.Stack.exercise.MonoStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * 描述：给出一组数字，求一区间，使得区间元素和乘以区间最小值最大，结果要求给出这个最大值和区间的左右端点。默认数组值大于0
 * 输入：3 1 6 4 5 2
 * 输出：60
 *        2 4
 * 解释：将2到4（6+4+5）这段区间相加，将和与区间内最小元素相乘获得最大数字60
 */

// 单调递减栈：栈顶数据始终最大

public class GetMaxSequence {
    public static void main(String[] args) {
        Solution solution = new GetMaxSequence().new Solution();
        int[] nums = {3,1,6,4,5,2};
        System.out.println(solution.GetMaxSequence(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1.设置一个单调递减的栈（栈内0~n为单调递增）
        // 2.当遇到小于栈顶元素的值，我们开始更新数据，因为当前遇到的值一定是当前序列最小的
        public int GetMaxSequence(int[] nums){
            int n = nums.length;
            Deque<Integer> stack = new ArrayDeque<>();

            int res=0;
            int start = 0;
            int end = 0;
            int top = 0;

            //构造前序和数列
            int[] sums = new int[n+1];
            sums[0]=1;
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i-1]+nums[i-1];
            }

            //给数组增加一个末位数
            int[] numsNew = Arrays.copyOf(nums,n+1);
            numsNew[n] = -1;

            for (int i = 0; i < numsNew.length; i++) {
                if (stack.isEmpty() || numsNew[i] >= numsNew[stack.peek()]){
                    stack.push(i);
                }else {
                    //遇到比栈顶小的数了，要开始做数据更新操作
                     while (!stack.isEmpty() && numsNew[i] < numsNew[stack.peek()]){
                        top = stack.pop();
                        int tmp = sums[i]-sums[top]; //i到top之间的和
                         tmp = tmp * numsNew[top];
                         if (tmp > res){
                             res = tmp;
                             start = top ;
                             end = i-1;
                         }
                     }
                     //为了保证栈的递增，所以要把最左侧，将其截断成和当前值一样
                     stack.push(top);
                     numsNew[top] = numsNew[i];
                }
            }
            System.out.println("res:"+res);
            System.out.println("start:"+start+"  end:"+end);
            return res;



        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
