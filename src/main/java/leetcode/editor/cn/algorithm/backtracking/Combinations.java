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



/* 回溯法应用1----组合问题
n为100，k为50的情况，暴力写法需要嵌套50层for循环
 回溯法就用递归来解决嵌套层数的问题，每一次的递归中嵌套一个for循环，那么递归就可以用于解决多层嵌套循环的问题了
 回溯法解决的问题都可以抽象为树形结构（N叉树），用树形结构来理解回溯就容易多了*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
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

        //循环遍历当前层
        for (int i = startIndex; i <= n ; i++) {
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