package leetcode.editor.cn.algorithm.dfs;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
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
// 👍 1745 👎 0

import java.util.*;

public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        res = solution.permute(nums);
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length ==0 ) return  res;

//        排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
        Deque<Integer> path = new ArrayDeque<>(); //java使用deque来作为栈的实现
        boolean[] used = new boolean[nums.length];  //默认都为false
        dfs(nums,0,res,path,used); //path是临时变量，当满足之后就会将path加入到res
        return res;
    }

    //深度优先遍历，回溯法,递归，顺序，栈
    private void dfs(int[] nums, int i, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        if (i==nums.length) {
            res.add(new ArrayList<>(path)); //path是个引用，path的更新会引起res中元素的更新，所以要用拷贝快照的方式
            return;
        }
        for (int j=0;j<nums.length;j++){
            if (used[j]) continue;

            path.addLast(nums[j]); //将该位置元素加入栈顶
            used[j] = true;

            dfs(nums,i+1,res,path,used);

            path.removeLast();
            used[j] = false;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}