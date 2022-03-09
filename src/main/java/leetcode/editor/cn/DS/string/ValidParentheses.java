package leetcode.editor.cn.DS.string;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2918 👎 0

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 ==1) return false;

        Map<Character,Character> pairs = new HashMap<Character, Character>(){
            {
            put(')','(');
            put(']','[');
            put('}','{');
            }
        };

        Deque<Character> stack = new LinkedList<Character>();
        for (int i=0;i<n;i++){  //1.traverse the string
            char ch = s.charAt(i); //2.get the char
            if (pairs.containsKey(ch)){ //3.1 if the char is right,needs left
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) return false;
                stack.pop(); //4 match success
            }else {
                stack.push(ch); //3.2 if the cha is left,waiting for match .push it
            }
        }
        return stack.isEmpty();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}