package competion.c302;

import java.util.HashMap;

//2 <= s.length <= 100
//s 由小写英文字母组成
//s 包含至少一个重复字母
public class repeatedCharacter {
    public static void main(String[] args) {
        Solution solution = new repeatedCharacter().new Solution();
        String s= "abcdd";
        System.out.println(solution.repeatedCharacter(s));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char repeatedCharacter(String s) {
            HashMap<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    if (map.get(s.charAt(i))==2) return s.charAt(i);
                }else map.put(s.charAt(i),1);
            }
            return s.charAt(s.length()-1);

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
