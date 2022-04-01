package leetcode.editor.cn.algorithm.backtracking;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//https://cloud.tencent.com/developer/article/1745476
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(solution.subsets(nums).toArray()));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)

//收集树形结构中树的所有节点的结果
class Solution {
    List<Integer> t = new ArrayList<>(); //存放已被选出的数字
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0,nums);
        return res;
    }

    private void backtracking(int i, int[] nums) {
        //终止条件
        if (i == nums.length){
            res.add(new ArrayList<Integer>(t)); //存放结果
            return; //返回
        }

        //向下归
        //1.添加它
        t.add(nums[i]);
        backtracking(i+1,nums);

        //2.不添加它
        t.remove(t.size()-1);
        backtracking(i+1,nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}