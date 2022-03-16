package leetcode.editor.cn.DS.Stack.exercise;

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

public class decodeString {
    public static void main(String[] args) {
        Solution solution = new decodeString().new Solution();
        String s = "3[a2[c]]";
        System.out.println(solution.decodeString(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //遇到括号匹配问题，使用栈，一定要遇到右括号才能出栈
        //遍历到最后，有个res是没有入栈的，与已经入栈的token进行拼接

        public String decodeString(String s) {

            Deque<Integer> numStack = new ArrayDeque<>();
            Deque<StringBuffer> resStack = new ArrayDeque<>();
            StringBuffer res = new StringBuffer();
            int num = 0;

            for (char c : s.toCharArray()){ //string转化为char数组，s.toCharArray()
                //1.数字
                if (Character.isDigit(c)){
                    //字符转化为数字
                    num = num *10 + c - '0';// 如果是21，那么逐步计算
                 //2.字符[
                }else if (c == '['){
                    //准备开始计数,把字符和数组分别放入字符栈和数字栈
                    resStack.push(res);
                    numStack.push(num);
                    //重新开始计算
                    res = new StringBuffer();
                    num = 0;
                }
                 else if (c == ']'){
                     //收割时刻 ,字符和数字出栈
                     StringBuffer token = resStack.pop();
                     int n = numStack.pop();

                     //重复次数
                     for (int i=0;i<n;i++){
                         token.append(res);
                     }
                     res = token;
                 //3.1省略，直接以字符开头
                }else {
                     //这里改变的都是res的应用值
                    res.append(c);
                }
            }


            return res.toString();
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
