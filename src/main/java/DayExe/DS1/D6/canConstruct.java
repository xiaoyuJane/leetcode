package DayExe.DS1.D6;

import java.util.HashMap;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class canConstruct
{
    public static void main(String[] args) {
        Solution solution = new canConstruct().new Solution();
        System.out.println(solution.canConstruct1("aa", "aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //等价于ransomNote是否是magazine的子集
        public boolean canConstruct(String ransomNote, String magazine) {
            if(ransomNote.length() > magazine.length()) return false;

            //由于只由小写英文字母组成，可以取巧，类似于基数排序的方法定义一个字母的数组
            int[] nums = new int[26];
            for (char c : magazine.toCharArray()) {
                nums[c-'a']++;
            }
            for (char c : ransomNote.toCharArray()) {
                nums[c-'a']--;
                if (nums[c-'a']<0) return false;
            }
            return true;
        }

        public boolean canConstruct1(String ransomNote, String magazine) {
            HashMap<Character, Integer> hash = new HashMap<>();
            for(int i=0;i<ransomNote.length();i++){
                int index=0;
                char r= ransomNote.charAt(i);
                if( hash.get(r)!=null) {
                    index=(int) hash.get(r);
                }
                index=magazine.indexOf(r,index);
                hash.put(r, index+1); //妙在这里，由于使用index of自带了从前往后的属性，所以每次put的时候将其下标加1，就不会找到之前遍历过的地方
                if(index==-1){
                    return false;
                }
            }
            return true;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
