package DayExe.DS2.D1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        Solution solution = new threeSum().new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //回溯+剪枝操作
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            backtracking(nums,0);
            return res;
        }

        private void backtracking(int[] nums,int startIdx){
            //1.回溯终止条件
            if (path.size()==3){
                if (path.get(0)+path.get(1)+path.get(2)==0){
                    res.add(new ArrayList<>(path));
                }
                return;

            }

            //2.单层遍历
            for (int i = startIdx; i < nums.length; i++) {
                if (nums[i]>=0) break;
                path.add(nums[i]);
                backtracking(nums,i+1);
                path.remove(path.size()-1);
            }
        }


    }
//leetcode submit region begin(Prohibit modification and deletion)
}
