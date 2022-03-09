import java.util.*;

public class Test {
    public static void main(String[] args) {
       // [[],[0,2],[]]
        //[[],[0,2],[1]]
        int[][] nums = new int[][]{{},{0,2},{}};
        Solution solution = new Test().new Solution();
        System.out.println(solution.getAllValue(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean getAllValue(int[][] nums){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i].length != 0) {
                    for (int index: nums[i]){
                        if (nums[index].length == 0) index = -1;
                    }
                }else

            }
        return true;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
}
