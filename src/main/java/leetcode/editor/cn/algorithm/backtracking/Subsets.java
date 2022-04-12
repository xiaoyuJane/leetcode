package leetcode.editor.cn.algorithm.backtracking;

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
// 👍 1569 👎 0

import java.util.ArrayList;
import java.util.List;

//子集问题，也是一种组合，因为不介意顺序，所以回溯中需要有个startIndex
//子集的长度不固定，求解的是树搜索过程中所有结点
//递归的终止条件为剩余集合为空，对应的是startIndex >= nums.size

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex){

        //收集所有节点
        res.add(new ArrayList<>(path));

        // end condition
        if (startIndex >= nums.length) return;

        //单层搜索逻辑
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}