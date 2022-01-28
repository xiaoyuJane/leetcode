package leetcode.editor.cn.string;

//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 598 👎 0

//滑动窗口解法，时间复杂度为o(n)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        HashMap<String,Integer> map = new HashMap<>();
        int wl = words[0].length();
        int wn = words.length;
        int wsl = wl * wn;

        //map用来存匹配串中的单词和出现的次数
        for (String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        //使用双指针，left滑出，right滑入，保证一次遍历完s，而不需要回头二次循环遍历
        //由于wl是最小步长，为保证全部覆盖到，还需要对wl长度的不同位置开始遍历，才不会遗漏
        for (int i=0;i<wl;i++){
            int left=i,right=i,count=0;
            HashMap<String,Integer> tmp_map = new HashMap<>();
            //right是s的游标，一直滑动到s.length-wl处
            while (right+wl <= s.length()){
                //截取s对应的字符串word
                String s_word=s.substring(right,right+wl);
                tmp_map.put(s_word,tmp_map.getOrDefault(s_word,0)+1);
                right += wl;
                count++;

                //比较tmp_map和map来决定left的滑出
                while (tmp_map.getOrDefault(s_word,0)>map.getOrDefault(s_word,0)){
                    //tmp_map中出现了不满足的字符串后，将左边滑出，count值减1,更新tmp_map
                    String t_word = s.substring(left,left+wl);
                    count--;
                    tmp_map.put(t_word,tmp_map.getOrDefault(t_word,0)-1);
                    left+=wl;
                }
                if (count == wn) res.add(left);
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}