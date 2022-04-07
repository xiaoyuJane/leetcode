package leetcode.editor.cn.algorithm.backtracking;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 930 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsCutting {
    public static void main(String[] args) {
        Solution solution = new CombinationsCutting().new Solution();
        System.out.println(Arrays.toString(solution.combine(4,2).toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtracking(n,k,1);
            return res;
        }

        //回溯法的搜索过程就是一个树型结构的遍历过程
        private void backtracking(int n, int k, int startIndex){

            //递归的终止条件
            if (path.size() == k){
                res.add(new ArrayList<Integer>(path));  //注意点：新建一个ArrayList来存放结果数据集
                return;
            }

            //循环遍历当前层,并增加剪枝操作（i <= n-(k-path.size())+1），提前结束遍历，可以显著提高时间复杂度
            for (int i = startIndex; i <= n-(k-path.size())+1 ; i++) {
                //处理节点
                path.add(i);
                //递归处理
                backtracking(n,k,i+1);
                //回溯
                path.remove(path.size()-1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}