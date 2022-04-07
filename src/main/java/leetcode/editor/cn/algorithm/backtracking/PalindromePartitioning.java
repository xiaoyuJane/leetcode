package leetcode.editor.cn.algorithm.backtracking;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1071 👎 0

/**
 * 分割问题其实也可以抽象为组合问题
 * - 切割问题，有不同的切割方式
 * - 判断回文
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(Arrays.toString(solution.partition("aab").toArray()));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return res;
    }

    private void backtracking(String s, int index){
        //边界条件
        if (index >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        //单层搜索逻辑
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s,index,i)){
                String str = s.substring(index,i+1);
                path.add(str);
            }else {
                continue;
            }

            backtracking(s,i+1);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}