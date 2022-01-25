package leetcode.editor.cn;

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
        int i=0;
        int j=s.length()-1;
        char[] arr = s.toCharArray();
        while (i<j){
            while (i<s.length() && !isVowel(arr[i])){
                i++;
        }
            while (j>0 && !isVowel(arr[j])){
                j--;
            }
            if (i<j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) >=0;
    }

    public void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}