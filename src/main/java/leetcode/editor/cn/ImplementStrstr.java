package leetcode.editor.cn;

//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 
// 👍 1221 👎 0

//kmp 算法--前缀函数 （参考阮一峰的讲解，很通俗易懂）
// 原串只往右移，不进行回溯，可以想象成原串不动，匹配串跟随原串动，主动去匹配它
// 匹配串中利用前缀和后缀进行加快匹配，当不匹配的时候，字串并非只向右移动1位继续匹配，而是将字串的前缀移动到原串的后缀相同位置，即移动{相同字符-前缀后缀最大交集长度}位
//
//


public class ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {

        int n=haystack.length(), m=needle.length();
        if (m ==0) return 0;

        //1.构造前缀后缀最大交集长度数组的过程
        /*len 表示prefix数组的值
        * i表示prefix数组的下标
        * */
        int[]prefix = new int[m]; //初始都为0
        for (int i=1,len=0;i<m;i++){
            while (len>0 && needle.charAt(i)!=needle.charAt(i)){
                len=prefix[len-1];
            }
            if (needle.charAt(len)==needle.charAt(i)) len++; //
            prefix[i]=len;
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}