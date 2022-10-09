package competion.single.c313;

public class commonFactors {
    public static void main(String[] args) {
        Solution solution = new commonFactors().new Solution();
        System.out.println(solution.commonFactors(25,30));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int commonFactors(int a, int b) {
            int tmp = Math.min(a, b);
            int count =0;
            for (int i = 1; i <= tmp; i++) {
                if (a%i ==0 && b%i==0) count++;
            }
            return count;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
