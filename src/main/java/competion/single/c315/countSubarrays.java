package competion.single.c315;

public class countSubarrays {
    public static void main(String[] args) {
        Solution solution = new countSubarrays().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            long res = 0L;
            int[] min = new int[nums.length];
            int[] max = new int[nums.length];
            min[0]=nums[0];
            max[0]=nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i]<min[i-1]) min[i]=nums[i];
                if (nums[i]>max[i-1]) max[i]=nums[i];
            }






            return res;
        }

        public long countSubarrays2(int[] nums, int minK, int maxK) {
            long min = -1, max = -1, index = -1, count = 0;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if (x == minK) min=i;
                if (x == maxK) max=i;
                if (x<minK || x>maxK) index=i;
                count += Math.max(Math.min(min,max)-index,0);

            }
            return count;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
