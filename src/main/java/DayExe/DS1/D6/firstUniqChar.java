package DayExe.DS1.D6;

import java.util.*;

public class firstUniqChar {
    public static void main(String[] args) {
        Solution solution = new firstUniqChar().new Solution();
        String s = "aabb";
        System.out.println(solution.firstUniqChar(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> maps = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                maps.put(c,maps.getOrDefault(c,0)+1);
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (maps.get(c) ==1) return i;
            }
            return -1;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
