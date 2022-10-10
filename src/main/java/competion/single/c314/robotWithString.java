package competion.single.c314;

import java.util.ArrayList;
import java.util.Arrays;

public class robotWithString {
    public static void main(String[] args) {
        Solution solution = new robotWithString().new Solution();
        String s ="zza";
        System.out.println(solution.robotWithString(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String robotWithString(String s) {
            char[] lists = s.toCharArray();
            Arrays.sort(lists);

            return new String(lists);

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
