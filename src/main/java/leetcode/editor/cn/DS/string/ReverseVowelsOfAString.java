package leetcode.editor.cn.DS.string;

//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 235 👎 0

import java.util.HashMap;
import java.util.Map;

public class ReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        String s = "hello";
        System.out.println(s);
        String res = solution.reverseVowels(s);
        System.out.println(res);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length-1;
        Map<Character,Integer> map = new HashMap<>(){{
            put('a',-1);
            put('e',-1);
            put('i',-1);
            put('o',-1);
            put('u',-1);
            put('A',-1);
            put('E',-1);
            put('I',-1);
            put('O',-1);
            put('U',-1);

        }};

        while (left<right){
            if (map.containsKey(str[left]) && map.containsKey(str[right])){
               char temp = str[left];
               str[left] = str[right];
               str[right] = temp;
               left++;
               right--;
            }else if (map.containsKey(str[left])) right--;
            else if (map.containsKey(str[right])) left++;
            else {
                left++;
                right--;
            }
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i<str.length; i++){
            res.append(str[i]);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}