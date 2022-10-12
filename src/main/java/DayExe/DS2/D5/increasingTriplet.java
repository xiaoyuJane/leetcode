package DayExe.DS2.D5;

public class increasingTriplet {
    public static void main(String[] args) {
        Solution solution = new increasingTriplet().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //通用
        public boolean increasingTriplet(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return false;
            }
            //从左边开始的最小值数组
            int[] leftMin = new int[n];
            leftMin[0] = nums[0];
            for (int i = 1; i < n; i++) {
                leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
            }

            //从右边开始的最大值数组
            int[] rightMax = new int[n];
            rightMax[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
            }

            //遍历中间数，
            // 如果nums[i] > leftMin[i - 1]，说明 左边有比它小的值
            // 如果 nums[i] < rightMax[i + 1]，说明 右边有比它大的值
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                    return true;
                }
            }
            return false;

        }

        //贪心算法：为了找到递增的三元子序列，first和second应该尽可能地小，此时找到递增的三元子序列的可能性更大。
        public boolean increasingTriplet1(int[] nums){
            int n = nums.length;
            if (n < 3) {
                return false;
            }
            int first = nums[0], second = Integer.MAX_VALUE;

            for (int i = 1; i < n; i++) {
                int num = nums[i];
                //收割结果的时候
                if (num > second) {
                    return true;
                }
                //更新first和second的时候
                else if (num > first) {
                    second = num;
                } else {
                    first = num;
                }
            }
            return false;


        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
