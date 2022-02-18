package leetcode.editor.cn.Stack;

public class dailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new dailyTemperatures().new Solution();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] res = solution.dailyTemperatures(temperatures);
        for (int n : res){
            System.out.println(n);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
