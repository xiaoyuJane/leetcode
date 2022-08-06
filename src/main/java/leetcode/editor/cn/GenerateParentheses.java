package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2543 👎 0


//出栈方式的组合
import java.util.*;

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Set<String> res = new HashSet<>();
    StringBuilder path = new StringBuilder();
    String type = "";

    public List<String> generateParenthesis(int n) {
        backtracking(n);
        return new ArrayList<>(res);
    }

    private void backtracking(int n){
        if (n == 1){
            path.append("()");
            res.add(new String(path));
            return;
        }

        //首部添加
        path.append("()");
        backtracking(n-1);


        path.delete(0,path.length());
        path.append("(");
        backtracking(n-1);
        path.append(")");



        backtracking(n-1);
        path.append("()");



    }


}
//leetcode submit region end(Prohibit modification and deletion)

}