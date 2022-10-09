package DayExe.DS2.D2;

import java.util.HashMap;

public class sortColors {
    public static void main(String[] args) {
        Solution solution = new sortColors().new Solution();
        int[] nums = {1};
        solution.sortColors(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            //计数
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num,map.getOrDefault(num,0)+1);
            }
            int c0= map.getOrDefault(0,0);
            int c1 = map.getOrDefault(1,0);
            //重写数组
            for (int i = 0; i <c0; i++) {
                nums[i]=0;
            }
            for (int i = c0; i < c0+c1; i++) {
                nums[i]=1;
            }
            for (int i = c0+c1; i < nums.length; i++) {
                nums[i]=2;
            }


        }

        //双指针-fail
        public void sortColors1(int[] nums){
            int p = 0, q = nums.length-1;
            for (int i = p; i <= q; i++) {
                if (nums[i]==0 && i==p)  p++;
                if (nums[i]==0 && i>p)
                {
                    nums[i]=nums[p];
                    nums[p]=0;
                    p++;
                }
                if (nums[i]==2){
                    nums[i] = nums[q];
                    nums[q]=2;
                    q--;
                }

            }
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
