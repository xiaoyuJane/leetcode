package leetcode.editor.cn.algorithm.backtracking;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 910 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 集合含有重复元素，元素不能重复选择，限制条件为和
 * - 去重的语义为，使用过的元素不能重复选取
 * - 组合问题可以抽象为树形结构，那么“使用过”在这个树形结构上是有两个维度的，一个维度是同一树枝上使用过，一个维度是同一树层上使用过。
 * - 去重的是同一树层上的“使用过”，同一树枝上的都是一个组合里的元素，不用去重。
 * - 树层去重，需要对数组排序
 */
public class CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0,used);
        return res;

    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used){

        //terminal condition
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum+candidates[i] <=target; i++) {
            //去重处理
            //used[i - 1] == true，说明同一树支candidates[i - 1]使用过
            //used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            //去重的是同一树层上的“使用过”，同一树枝上的都是一个组合里的元素，不用去重。
            if (i>0 && candidates[i] == candidates[i-1] && !used[i - 1]) continue;


            //处理节点
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;

            //因为不能重复选取元素，这里的startIndex需要加1
            backtracking(candidates,target,sum,i+1,used);

            sum = sum- candidates[i];
            path.remove(path.size()-1);
            used[i] = false;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}