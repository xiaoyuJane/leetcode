package competion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 6164. 数位和相等数对的最大和
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
 *
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 * 示例 2：
 *
 * 输入：nums = [10,12,19,14]
 * 输出：-1
 * 解释：不存在满足条件的数对，返回 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class maximumSum {
    public static void main(String[] args) {
        Solution solution = new maximumSum().new Solution();
        System.out.println(solution.getBitSum(401));
//        System.out.println(solution.getBitSum(7));
        int[] nums = {279,169,463,252,94,455,423,315,288,64,494,337,409,283,283,477,248,8,89,166,188,186,128};
//        List<Integer> list = new ArrayList<>();
//        list.add(14);
//        list.add(12);
//        list.add(13);
//        list.sort((o1, o2) -> o2-o1);
//        System.out.println(list);

        System.out.println(solution.maximumSum(nums));
//        System.out.println(solution.getMaxSum(new int[]{43,7,70,60}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] nums) {
           /* int res =-1;
            HashMap<Integer, List<Integer>> maps = new HashMap<>();
            if (nums.length<=1) return res;

            int[] sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                sum[i]= getBitSum(nums[i]);
            }

            for (int i = 0; i < sum.length; i++) {
                if (!maps.containsKey(sum[i])) {
                    List<Integer> turples = new ArrayList();
                    turples.add(nums[i]);
                    maps.put(sum[i],turples);
                }
                else {
                    List<Integer> turples = maps.get(sum[i]);
                    turples.add(nums[i]);
                    turples.sort((o1, o2) -> o2-o1);
                    res =Math.max(res,turples.get(0)+turples.get(1));

                }
            }


            return res;*/

            int n=nums.length,max=-1;

            int[][] p=new int[91][2];

            for(int i=0;i<n;i++){
                int sum=0,num=nums[i];
                while(num!=0){
                    sum+=num%10;
                    num/=10;
                }

                num=nums[i];
                if(p[sum][1]<=num){
                    p[sum][1]=num;
                    if(p[sum][0]<num){
                        p[sum][1]=p[sum][0];
                        p[sum][0]=num;
                    }
                }


                if(p[sum][0]!=0&&p[sum][1]!=0){
                    max=Math.max(max,p[sum][0]+p[sum][1]);
                }
            }
            return max;

        }

        public int getBitSum(int num){
            int res =num%10;
            while (num/10!=0){
                num = num/10;
                res +=num%10;
            }
            return res;
        }

        public int getMaxSum(int[] nums){
            if (nums.length<2) return -1;
            Arrays.sort(nums);
            System.out.println(nums);
            return nums[nums.length-1]+nums[nums.length-2];
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
