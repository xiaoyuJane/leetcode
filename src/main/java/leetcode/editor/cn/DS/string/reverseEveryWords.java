package leetcode.editor.cn.DS.string;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 * 相关标签
 * 双指针
 * 字符串
 */
public class reverseEveryWords {
    public static void main(String[] args) {
        Solution solution = new reverseEveryWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuffer res = new StringBuffer();
            String[] sArray = s.split(" ");
            for (int i =0 ;i<sArray.length;i++){
                String string = sArray[i];
                StringBuffer tmp = new StringBuffer();
                for (int k=string.length()-1;k>=0;k--){
                    tmp.append(string.charAt(k));
                }
                res.append(tmp);
                res.append(" ");
            }


            return res.toString().substring(0,res.length()-1);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
