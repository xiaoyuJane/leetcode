package leetcode.editor.cn.dfs;

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
// 👍 926 👎 0
//组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），
import java.util.*;

public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = {1,1,2};
        List<List<Integer>> res = solution.permuteUnique(nums);
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }


    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums,0,path,res,used);
        return res;
    }

    private void dfs(int[] nums, int i, Deque<Integer> path, List<List<Integer>> res,boolean[] used) {
        if (i == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j=0;j<nums.length;j++){
            if (used[j]) continue;
            //减枝操作,针对去重操作
            if (j>0 && nums[j] == nums[j-1] && !used[j-1]) continue;

            path.addLast(nums[j]);
            used[j] = true;
            dfs(nums,i+1,path,res,used);
            used[j] = false;
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}