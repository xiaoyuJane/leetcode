package competion.doubleCom.c88;

import java.util.*;

public class equalFrequency {
    public static void main(String[] args) {
        Solution solution = new equalFrequency().new Solution();
        String word = "bac";
        System.out.println(solution.equalFrequency(word));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equalFrequency(String word) {
            HashMap<Character, Integer> maps = new HashMap<>();
            for (char c : word.toCharArray()) {
                if (!maps.containsKey(c)) maps.put(c,1);
                else maps.put(c,maps.get(c)+1);
            }
            return true;


        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
