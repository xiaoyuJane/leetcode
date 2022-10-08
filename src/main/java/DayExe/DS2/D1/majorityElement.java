package DayExe.DS2.D1;

public class majorityElement {
    public static void main(String[] args) {
        Solution solution = new majorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int res = nums[0];
            int count = 1;
            for (int i =1; i < nums.length; i++) {
                if (nums[i]!=res) count--;
                else count++;
                if (count<0){
                    res = nums[i];
                    count =1;
                }
            }
            return res;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
