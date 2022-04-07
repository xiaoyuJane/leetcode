package leetcode.editor.cn.algorithm.backtracking;

//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics 数组 回溯 
// 👍 448 👎 0


/**
 * 组合问题的变种
 * 集合为[1,2,3,4,5,6,7,8,9],个数为k，增加限制，集合之和为n
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        System.out.println(Arrays.toString(solution.combinationSum3(3,7).toArray()));

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n,k,1);
        return res;
    }

    /**
     * 递归方法
     * @param n-总和
     * @param k-个数
     * @param startIndex -起始位置
     */
    private void backtracking( int n ,int k, int startIndex ){
        //终止条件（深度）
        if (path.size() == k) {
            if (n == 0)  res.add(new ArrayList<>(path));
            return;
        }

        //剪枝代码
        if (n<0) return;

        //集合大小为树的宽度
        for (int i = startIndex; i <= 10-k+path.size() ; i++){
            //处理节点
            path.add(i);
            n = n-i;
            //递归处理
            backtracking(n,k,i+1);
            //回溯
            n = n+i;
            path.remove(path.size()-1);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}