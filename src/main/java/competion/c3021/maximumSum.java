package competion.c3021;

import java.util.Arrays;

/**
 * 6164. 数位和相等数对的最大和
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），
 * 且 nums[i] 的数位和 与  nums[j] 的数位和相等。
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
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 */
public class maximumSum {
    public static void main(String[] args) {
        Solution solution = new maximumSum().new Solution();
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
        /**
         * 算法： 单纯的hashMap或者暴力法会导致超时，只能用数学法或者其他方法取巧来简化无谓的挣扎
         * 这里单个num的长度是9位，求和起来最大数位也只为90
         * @param nums
         * @return
         */
        public int maximumSum(int[] nums) {
            int n=nums.length,max=-1;
            int[][] p=new int[91][2];

            //对num数组的每个元素处理
            for(int i=0;i<n;i++){
                //step1.求数字位和
                //求和的经典操作：
                // 1. 定义基本sum = 0
                // 2. 先取低位值相加，即sum = sum + num%10
                // 3. num右移动，即 num = num/10
                int sum=0,num=nums[i];
                while(num!=0){
                    sum+=num%10;
                    num/=10;
                }

                //step2. 数对二维数组存放相等的两个元素，保持从大到小的两个位置
                num=nums[i];
                if(p[sum][1]<=num){
                    //首先放到第二位
                    p[sum][1]=num;
                    //如果第一位小于第二位，则交换位置，否则不变 ==》这样保持了从大到小的位置排列
                    if(p[sum][0]<num){
                        //这里交换p[sum][0]和p[sum][1]的位置
                        p[sum][1]=p[sum][0];
                        p[sum][0]=num;
                    }
                }

                //step3.求最大值
                if(p[sum][0]!=0&&p[sum][1]!=0){
                    max=Math.max(max,p[sum][0]+p[sum][1]);
                }
            }
            return max;

        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
