package leetcode.editor.cn.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */


public class longestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new longestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder res = new StringBuilder();
            String ref = strs[0];
            for (int i=0;i<ref.length();i++){
                int index = 0;
                while (index<strs.length){
                    if (i >= strs[index].length() || strs[index].charAt(i) != ref.charAt(i)) return res.toString();

                    index++;
                }
                res.append(ref.charAt(i));
            }
            return res.toString();

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
