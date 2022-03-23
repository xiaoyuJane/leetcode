package leetcode.editor.cn.DS.List.array.exercise;

import java.util.Arrays;

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
        int[] res = solution.dailyTemperatures3(temperatures);
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
                    }else if (res[j] == 0) break;
                    else {
                        j+=res[j];
                    }
                }
            }
            return res;
        }



    }
//leetcode submit region begin(Prohibit modification and deletion)
}
