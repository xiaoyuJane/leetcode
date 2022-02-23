package leetcode.editor.cn.string;

import java.util.Stack;

/**
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
 * 示例 3：
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
 * 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 *
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 * 进阶：
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * 相关标签
 * 双指针
 * 字符串

 */
public class reverseWords {
    public static void main(String[] args) {
        Solution solution = new reverseWords().new Solution();
        String s = "a good     example     ";
        System.out.println(solution.reverseWords(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //常规解法--数组的翻转
        public String reverseWords(String s) {
           String[] wordArray = s.split(" "); //用正则split
           StringBuffer stringBuffer = new StringBuffer();

           int len = wordArray.length;
           while (len-->0){
               if (!wordArray[len].isEmpty()){ //对非空的项进行添加
                   if (stringBuffer.length()>0) stringBuffer.append(" ");
                   stringBuffer.append(wordArray[len]);
               }
           }

           return stringBuffer.toString();
        }

        // 方法二：双指针，原地解法
        // 时间复杂度：O(n)，n = s.length
        // 空间复杂度：O（1）
        public String reverseWords_2(String s) {
            // 删除任何前导和尾随空格。
            s = s.trim();
            // 字符串长度
            int len = s.length();
            // 单词起止坐标
            int begin = len, end = len;
            while (len-- > 0) {
                // 遇到非单词分隔的空格符的情况
                // 去掉空格符
                if (s.charAt(len) == ' ' && begin == end) {
                    // 新的字符串
                    s = s.substring(0, len) + s.substring(len + 1, s.length());
                    begin--;
                    end--;
                    // 遇到单词分隔的空格符的情况
                } else if (s.charAt(len) == ' ' && begin != end) {
                    String word = s.substring(begin, end);
                    s = s.substring(0, len) + (end < s.length() ? s.substring(end, s.length()) : "") + word + " ";
                    begin--;
                    end = begin;
                    // 非空格符的情况，寻找单词起始坐标
                } else {
                    begin--;
                }
            }
            // 处理最后一个单词
            String word = s.substring(0, end);
            s = s.substring(end, s.length()) + word;
            return s;
        }

        // 方法四：递归
        public String reverseWords_4(String s) {
            s = s.trim();
            int len = s.length();
            while (len-- > 0) {
                if (s.charAt(len) == ' ') {
                    String word = s.substring(len + 1, s.length());
                    return word + " " + reverseWords_4(s.substring(0, len));
                }
            }
            return s;
        }

        // 方法五：栈
        public String reverseWords5(String s) {
            // 设置一个栈存放单词
            Stack<String> stack = new Stack<>();
            s.trim();
            String[] wordArray = s.split(" ");
            for (String word : wordArray) {
                if (!word.isEmpty()) {
                    stack.add(word);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (!stack.isEmpty()) {
                stringBuffer.append(stack.pop());
                if (!stack.isEmpty()){
                    stringBuffer.append(" ");
                }
            }
            return stringBuffer.toString();
        }




    }
//leetcode submit region begin(Prohibit modification and deletion)
}
