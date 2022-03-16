package leetcode.editor.cn.algorithm.dfs;

//给定一个经过编码的字符串，返回它解码后的字符串。
//
//        编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//        你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
//        此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//         
//
//        示例 1：
//
//        输入：s = "3[a]2[bc]"
//        输出："aaabcbc"
//        示例 2：
//
//        输入：s = "3[a2[c]]"
//        输出："accaccacc"
//        示例 3：
//
//        输入：s = "2[abc]3[cd]ef"
//        输出："abcabccdcdcdef"
//        示例 4：
//
//        输入：s = "abc3[cd]xyz"
//        输出："abccdcdcdxyz"
//         
//
//        提示：
//
//        1 <= s.length <= 30
//        s 由小写英文字母、数字和方括号 '[]' 组成
//        s 保证是一个 有效 的输入。
//        s 中所有整数的取值范围为 [1, 300] 
//        相关标签
//        栈
//        递归
//        字符串


import java.util.ArrayDeque;
import java.util.Deque;

public class decodeStringdfs {
    public static void main(String[] args) {
        Solution solution = new decodeStringdfs().new Solution();
        String s = "3[a2[c]]";
        System.out.println(solution.decodeString(s));
    }
    //如果当前位置为数字位，那么后面一定包含一个用方括号表示的字符串，即属于这种情况：k[...]
    // 我们可以先解析出一个数字，然后解析到了左括号，递归向下解析后面的内容，遇到对应的右括号就返回，
    // 此时我们可以根据解析出的数字 x 解析出的括号里的字符串 s' 构造出一个新的字符串 x x s'
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //全局变量
        String src; //输入字符串
        int p; //游标

        public String decodeString(String s) {
            src = s;
            p = 0;
            return getString();
        }

        //解码函数
        private String getString() {
            //1.终止条件
            if (p == src.length() || src.charAt(p) == ']') return "";

            char cur = src.charAt(p);
            int n = 1;
            String res = "";

            if (Character.isDigit(cur)){
                n = getDigits();

                //2.数字后面是向下递
                ++p;
                String str = getString();
                ++p;
                //3，向上归
                while (n-->0) res += str;

            }// 3.非终止条件：如果是字母，不做递归，只返回结果
            else if (Character.isLetter(cur)) res = String.valueOf(src.charAt(p++)); //isLetter() 方法用于判断指定字符是否为字母。

            return  res + getString();


        }

        //从字符变成数值
        private int getDigits() {
            int res = 0;
            while (p<src.length() && Character.isDigit(src.charAt(p))) res = res *10 + src.charAt(p++) - '0';
            return  res;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
