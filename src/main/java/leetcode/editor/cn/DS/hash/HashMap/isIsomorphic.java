package leetcode.editor.cn.DS.hash.HashMap;
/**
 * 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 * 相关标签
 * 哈希表
 * 字符串
 */

import java.util.HashMap;
import java.util.Map;

public class isIsomorphic {
    public static void main(String[] args) {
        Solution solution = new isIsomorphic().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //本质在于双射
        public boolean isIsomorphic(String s, String t) {
            return oneIsIsomorphic(s,t) && oneIsIsomorphic(t,s);

        }

        //解法2，本质是模式串匹配
        public boolean isIsomorphic2(String s, String t) {
            Map<Object, Integer> map = new HashMap<>();
            for (Integer i = 0; i < s.length(); i++) {
                if (map.put(s.charAt(i), i) != map.put(String.valueOf(t.charAt(i)), i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean oneIsIsomorphic(String s, String t){
            Map<Character,Character> map = new HashMap<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),t.charAt(i));
                }
            }
            for (int i = 0; i < n; i++) {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            return true;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
