package leetcode.editor.cn.algorithm.backtracking;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3：
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1916 👎 0


/**
 * 排列是有位置的,使用used数组避免重复使用同一个元素
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used){
        //terminal condition
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //一个排列里一个元素只能使用一次
        for (int i = 0; i < nums.length; i++) {
            //元素去重，一个元素不能选择多次
            if (used[i]) continue;

            used[i] = true;
            path.add(nums[i]);
            backtracking(nums,used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}