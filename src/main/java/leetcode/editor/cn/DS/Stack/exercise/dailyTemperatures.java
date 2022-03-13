package leetcode.editor.cn.DS.Stack.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *  
 *
 * 提示：
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * 相关标签
 * 栈
 * 数组
 * 单调栈

 */
public class dailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new dailyTemperatures().new Solution();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] res = solution.dailyTemperatures2(temperatures);
        System.out.println(Arrays.toString(res));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //1.暴力求解法，遇到比它小或者等于的时候就退出，并存储结果状态
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] answer = new int[n];

            for (int i = 0; i<n ; i++){
                for(int j = i+1;j<n;j++){
                    if (temperatures[j]>temperatures[i]) {
                        answer[i]= j-i;
                        break;
                    }
                }
            }

            return answer;
        }

        //2.使用栈的方法，因为需要判断第一个大于temperatures[i]的下标值，并用maxIndex - i，作为结果返回
        // answer[i] 是指在第 i 天之后，才会有更高的温度
        public int[] dailyTemperatures2(int[] temperatures) {
            int n = temperatures.length;
            Deque<Integer> stack = new ArrayDeque<>(); //存放下标
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){ //遇见了大于的就出来，并计算结果
                    int index = stack.pop();
                    res[index] = i-index;
                }
                stack.push(i); //温度比较小的就留在栈中，等待匹配
            }
            return res;

        }

        // 3.从后往前遍历，利用后面已知的信息
        public int[] dailyTemperatures3(int[] temperatures){
            int n = temperatures.length;
            int[] res =new int[n];
            for (int i = n-2; i >=0; i--) {
                int j = i+1;
                while (j<n){
                    if (temperatures[j]>temperatures[i]){
                        res[i] = j-i;
                        break;
                    }else if (res[j] == 0) break; //剪枝操作，如果后面的res值为0，表明找不到比它大的天数了。到这里就break跳出，无需比较
                    else {
                        j+=res[j]; //i对应的值大于j的情况下，j后面有比j大大数，直接让j跳到j= j+res[j]那里，与比j大的数开始比较
                    }
                }
            }
            return res;
        }



    }
//leetcode submit region begin(Prohibit modification and deletion)
}
