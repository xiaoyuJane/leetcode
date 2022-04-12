package leetcode.editor.cn.algorithm.backtracking;

//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
// 示例 1：
//
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
//输入: candidates = [2], target = 1
//输出: []
// 
// 提示：
//
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1883 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 组合问题的变种
 * - 元素可以重复选取（递归不再是从下个元素开始）
 * - 没有个数要求（终止条件不再通过个数来判定）
 * - 总和确定（递归终止条件为sum == target，剪枝条件为sum>target）
 * - 排序和剪枝配套使用
 */
public class CombinationSum{
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
       backtracking(candidates,target,0,0);
       return res;
    }

    //一个集合求组合的话，需要startIndex
    private void backtracking(int[] candidates, int target, int sum,int startIndex){

        //pruning
        if (target < sum) return;

        //terminal condition
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        //排序加剪枝判断,组合问题需要从startIndex处开始计算
        for (int i = startIndex; i < candidates.length && sum+candidates[i] <=target; i++) {
            //handle data
            path.add(candidates[i]);
            sum += candidates[i];
            //dfs, 可重复取元素，那i就不加1
            backtracking(candidates,target,sum,i);
            //back
            sum = sum- candidates[i];
            path.remove(path.size()-1);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}