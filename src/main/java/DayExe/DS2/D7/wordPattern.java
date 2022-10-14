package DayExe.DS2.D7;

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    public static void main(String[] args) {
        Solution solution = new wordPattern().new Solution();
        String pattern = "abba";
        String s = "dog cat cat fish";
        System.out.println(solution.wordPattern2(pattern,s));;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //containsValue
        public boolean wordPattern(String pattern, String s) {
            String[] strings = s.split(" ");
            HashMap<Character, String> map = new HashMap<>();
            if (strings.length != pattern.length()) return false;

            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (!map.containsKey(c)) {
                    if (!map.containsValue(strings[i])) map.put(c,strings[i]);
                    else return false;

                }else if (!map.get(c).equals(strings[i])) return false;
            }
            return true;


        }

        public boolean wordPattern2(String pattern, String s) {
            String[] words = s.split(" ");
            if (words.length != pattern.length()) {
                return false;
            }
            HashMap<Object, Integer> map = new HashMap<>();
            for (Integer i = 0; i < words.length; i++) {
                if (map.put(pattern.charAt(i), i)!= map.put(words[i], i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
