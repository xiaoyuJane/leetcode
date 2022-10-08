package DayExe.D6;

import java.util.Arrays;

public class isAnagram {
    public static void main(String[] args) {
        Solution solution = new isAnagram().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] nums1 = new int[26];
            int[] nums2 = new int[26];
            for (char c : s.toCharArray()) {
                nums1[c-'a']++;
            }
            for (char c : t.toCharArray()) {
                nums2[c-'a']++;
            }
            return Arrays.equals(nums1,nums2);

        }


        public boolean isAnagram2(String s, String t) {
            // 如果 ss 和 tt 的长度不同，tt 必然不是 ss 的异位词
            if (s.length() != t.length()) {
                return false;
            }
            //t 是 s 的异位词等价于「两个字符串排序后相等」
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
