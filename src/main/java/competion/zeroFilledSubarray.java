package competion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//提示：
//
//1 <= nums.length <= 10^5
//-10^9 <= nums[i] <= 10^9
public class zeroFilledSubarray {
    public static void main(String[] args) {
        Solution solution = new zeroFilledSubarray().new Solution();
        int[] nums = new int[100000];
//        System.out.println(Math.pow(2,100000));
        int sum =0;
        for (int i = 1; i <= 100000; i++) {
            sum += i;
        }
        System.out.println(sum);
//        System.out.println(solution.zeroFilledSubarray(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long res = 0L;
            ArrayList<Integer> list = new ArrayList();

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) count++;
                else {
                    if (count >0) list.add(count);
                    count=0;
                }
            }
            if (count>0) list.add(count);

            if (list.size()==0) return 0;
            for (Integer integer : list) {
                res += (1+integer)*integer/2L;
            }


            return res;
        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
