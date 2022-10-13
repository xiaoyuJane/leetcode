package DayExe.DS2.D6;

import java.util.HashMap;

public class longestPalindrome {
    public static void main(String[] args) {
        Solution solution = new longestPalindrome().new Solution();
        String s = "ccc";
        System.out.println(solution.longestPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int res=0;
            boolean flag = false;

            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }

            for (Integer value : map.values()) {
                int len = value/2;
                int c = value%2;

                if (c==1) flag=true;
                res+=len*2;
            }
            return flag ? res+1:res;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
