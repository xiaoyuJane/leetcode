package competion.single.c312;

import java.util.ArrayList;
import java.util.List;

public class goodIndices {
    public static void main(String[] args) {
        Solution solution = new goodIndices().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 数学公式法
     */
    class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            int[] left = new int[nums.length], right = new int[nums.length];

            //下标i之前的k个元素是非递增的线段数 。
            for (int i = 2; i < nums.length; i++) {
                //如果后面元素比前一个元素大，即为递增的，不满足非递增，left[i]=0;
                if (nums[i - 1] > nums[i - 2]) {
                    left[i]=0;
                }
                //否则是递增的，在前一个结果上+1
                else left[i]= left[i - 1] + 1;
            }

            //下标i之后的k个元素是非递减的线数
            for (int i = nums.length - 3; i >= 0; i--) {
                //如果后前面元素比后一个元素大，即为递减的，不满足非递减，right[i]=0;
                if(nums[i + 1] > nums[i + 2]){
                    right[i] =  0;
                }else{
                    //否则是递减的，在前一个结果上+1
                    right[i] =  right[i + 1] + 1;
                }
            }

            //定义结果集，分别满足两个条件：
            // i之前，k个元素非递增，等价于k-1段非递增的线；
            // i之后，k个元素非递减，等价于k-1段非递减的线
            List<Integer> list = new ArrayList<>();
            for (int i = k; i < nums.length - k; ++i) {
                if (left[i] >= k - 1 && right[i] >= k - 1) {
                    list.add(i);
                }
            }
            return list;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
