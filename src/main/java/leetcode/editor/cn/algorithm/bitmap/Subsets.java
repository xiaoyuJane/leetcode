package leetcode.editor.cn.algorithm.bitmap;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1543 👎 0
//&按位与的运算规则是将两边的数转换为二进制位，然后运算最终值，运算规则即(两个为真才为真)
// 1&1=1 , 1&0=0 , 0&1=0 , 0&0=0

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.subsets(nums));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    //位运算
    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < (1<<n); ++i) {
            t.clear();
            for (int j = 0; j < n; ++j) {
                if ((i &(1<<j))!=0) t.add(nums[j]);
            }
            res.add(new ArrayList<Integer>(t));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}