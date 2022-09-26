package competion.single.c304;

import java.util.Arrays;

public class minimumOperations {
    public static void main(String[] args) {
        Solution solution = new minimumOperations().new Solution();
        int[] nums = {4,3,7,9,0};
        System.out.println(solution.minimumOperations(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(int[] nums) {
            int count = 0;

            Arrays.sort(nums);
            for (int j = 0; j < nums.length;j++) {
                int step = 0;
                boolean first = false;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i]>0 && !first) {
                        step=nums[i];
                        first = true;
                        nums[i]=0;
                        count++;
                    }else if (nums[i]>0){
                        nums[i] -=step;
                    }

                }
            }

            return count;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
