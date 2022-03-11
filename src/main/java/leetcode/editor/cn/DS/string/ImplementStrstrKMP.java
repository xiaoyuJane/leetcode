package leetcode.editor.cn.DS.string;

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


public class ImplementStrstrKMP {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstrKMP().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() ==0) return 0;
        //1.拿到最长前后缀长度数组
        int[] next = Next(needle);
        //2.双指针遍历，i指向字符串，j指向模式串,i和j在一个循环里控制变量的增值
        for (int i=0,j=0;i<haystack.length();i++){
            //当j与i匹配上了，但不是完全匹配，=>kmp的精髓：i位置不变，移动j位置到next[j-1]位置上
            while (j>0 && haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            //只有与给定字符串匹配上，j才会移动，也表明j代表模式串匹配上的个数值
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            //匹配上的个数(j)为模式串的长度，说明匹配成功
            if (j == needle.length()) return i-needle.length()+1;
        }

        return -1;
    }

    /*构造前缀后缀最大交集长度数组的过程
     * len 表示prefix数组的值
     * i 表示prefix数组的下标
     */
    public int[] Next(String needle){
        int[]prefix = new int[needle.length()]; //初始都为0
        //遍历模式串数组，找到其前缀数组的每个len值。i为游标，从1开始，prefix[0]=0
        //len为prefix数组对应的值，又跟游标移动密切相关。len指向i-1位置最长前缀的最后一个值的下一位，即可能是i位置的最长前缀值
        //i为模式串游标，也是i位置最长后缀的最后一个值
        for (int i=1,len=0;i<needle.length();i++){

            //len也为prefix数组前一个下标的值 len=prefix[i-1]，表示i位置要从prefix[i-1]开始检测（算上首位下标为0）
            //1  当游标前一位存在满足条件的前缀，但是到游标处字符并没有按照预期（len位置与i位置字符相等，则前缀长度可加1，否则不能加1，需要重新计算i位置对应的len值）
            while (len>0 && needle.charAt(len)!=needle.charAt(i)){
                //回退理解：当i位置预期不相等时，最长相等前后缀不可能再保持为len了，也不可能为len+1了，需要重新找len的匹配位置
                //由于在这一层里面，i的位置是不变的，所以它找的是i的最长后缀；
                // 观察已经比较过的len个长度的字符串，它是两个一模一样的字符串，到i开始不同；
                // 以观察[0,len-1]这部分字符串为例，找到它的最长前缀和最长后缀
                // 新len位置为[0,len-1]这部分字符串的最长前缀下个位置，与最长后缀的下个位置i进行比较
                len=prefix[len-1];
            }

            //2.1 len=0 且i位置与0位置相等，len++;不相等，那么len继续为默认值0
            //2.2 len>0 且i位置与len位置相等，表示前缀长度又可以增加1了；不相等走1.1分支
            if (needle.charAt(len)==needle.charAt(i)) len++;

            //3. len为prefix数组对应的值
            prefix[i]=len;
        }

        return prefix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}