package competion.c3021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个下标从 0 开始的字符串数组 nums ，其中每个字符串 长度相等 且只包含数字。
 *
 * 再给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [ki, trimi] 。对于每个 queries[i] ，你需要：
 *
 * 将 nums 中每个数字 裁剪 到剩下 最右边 trimi 个数位。
 * 在裁剪过后的数字中，找到 nums 中第 ki 小数字对应的 下标 。如果两个裁剪后数字一样大，那么下标 更小 的数字视为更小的数字。
 * 将 nums 中每个数字恢复到原本字符串。
 * 请你返回一个长度与 queries 相等的数组 answer，其中 answer[i]是第 i 次查询的结果。
 *
 * 提示：
 *
 * 裁剪到剩下最右边 x 个数位的意思是不断删除最左边的数位，直到剩下 x 个数位。
 * nums 中的字符串可能会有前导 0 。
 *
 *
 *输入：nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
 * 输出：[2,2,1,0]
 * 解释：
 * 1. 裁剪到只剩 1 个数位后，nums = ["2","3","1","4"] 。最小的数字是 1 ，下标为 2 。
 * 2. 裁剪到剩 3 个数位后，nums 没有变化。第 2 小的数字是 251 ，下标为 2 。
 * 3. 裁剪到剩 2 个数位后，nums = ["02","73","51","14"] 。第 4 小的数字是 73 ，下标为 1 。
 * 4. 裁剪到剩 2 个数位后，最小数字是 2 ，下标为 0 。
 *    注意，裁剪后数字 "02" 值为 2 。
 *
 *    输入：nums = ["24","37","96","04"], queries = [[2,1],[2,2]]
 * 输出：[3,0]
 * 解释：
 * 1. 裁剪到剩 1 个数位，nums = ["4","7","6","4"] 。第 2 小的数字是 4 ，下标为 3 。
 *    有两个 4 ，下标为 0 的 4 视为小于下标为 3 的 4 。
 * 2. 裁剪到剩 2 个数位，nums 不变。第二小的数字是 24 ，下标为 0 。
 *
 提示：

 1 <= nums.length <= 100
 1 <= nums[i].length <= 100
 nums[i] 只包含数字。
 所有 nums[i].length 的长度 相同 。
 1 <= queries.length <= 100
 queries[i].length == 2
 1 <= ki <= nums.length
 1 <= trimi <= nums[0].length



 */
public class smallestTrimmedNumbers {
    public static void main(String[] args) {
        Solution solution = new smallestTrimmedNumbers().new Solution();
        String[] nums={"102","473","251","814"};
        int[][] queries={{1,1},{2,3},{4,2},{1,2}};
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums,queries)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
            int[] res = new int[queries.length];

            List<List<Integer>> list= new ArrayList<>();
            int bits = nums[0].length(); //位数

            for (int i = 0; i < bits; i++) {
                List[] bucket = new List[10];
                for (int j = 0; j < 10; j++) bucket[j] = new ArrayList<Integer>();
                List<Integer> tmp = new ArrayList<Integer>();

                for (int j = 0; j < nums.length; j++) {
                    int idx;
                    //初始情况，按照j的顺序来定义初始顺序
                    if (i == 0 ) idx = j;
                    //从十位开始，基于个位的基本有序来比较
                    else idx = list.get(i-1).get(j);

                    String s = nums[idx];
                    //1. 将数值转换为下标，将下标存入数值，通过对bucket下标的遍历，就能得到大小的ijiao
                    bucket[s.charAt(bits-i-1) -'0'].add(idx);
                }

                //2.遍历bucket，得到从小到的数值的index
                for (int j = 0; j < 10; j++) {
                    tmp.addAll(bucket[j]);
                }
                //tmp：有序的index
                list.add(tmp); //list下标为位数，0为个位
            }

            for (int i = 0; i < queries.length; i++) {
                res[i] = list.get(queries[i][1]-1).get(queries[i][0]-1);
            }

            return res;


        }




        //专业选手的,内存消耗较少，执行用时较长，但思路简单，代码简洁
        public int[] smallestTrimmedNumbers2(String[] nums, int[][] queries){
            int[] result = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                Integer index[] = new Integer[nums.length], k = nums[0].length() - queries[i][1];

                for (int j = 0; j < nums.length; j++) {
                    index[j] = j;
                }
                Arrays.sort(index, Comparator.comparing(o -> nums[o].substring(k)));

                result[i] = index[queries[i][0] - 1];
            }

            return result;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
