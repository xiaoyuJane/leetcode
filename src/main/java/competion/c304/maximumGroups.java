package competion.c304;

import java.util.Arrays;

public class maximumGroups {
    public static void main(String[] args) {
        Solution solution = new maximumGroups().new Solution();
        int[] grades = {10,6,12,7,3,5};
        System.out.println(solution.maximumGroups(grades));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumGroups(int[] grades) {
            int count = 0;
            int n = grades.length;
            if (n ==1) return 1;

            double sqrt = Math.sqrt(n * 2.0);
            count =(int)Math.floor(sqrt)-1;


            return count;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
