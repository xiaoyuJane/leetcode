package leetcode.editor.cn.algorithm.backtracking;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 1012 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums,used);
        return res;

    }

    private void backtracking(int[] nums,boolean[] used){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //同一个元素只能取一次，全排列问题
            if (used[i]) continue;
            //元素有相同的，认为是同一个排列，解决去重问题
            if (i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;

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