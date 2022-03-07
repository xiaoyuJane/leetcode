package leetcode.editor.cn.hash.HashMap;

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
