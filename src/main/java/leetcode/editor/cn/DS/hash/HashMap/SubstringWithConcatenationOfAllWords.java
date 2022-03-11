package leetcode.editor.cn.DS.hash.HashMap;

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
// 👍 595 👎 0

//暴力法，通俗易懂，借用hashmap来判定是否相同，两层for寻魂，所以时间复杂度是2阶

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
        // 定义输出的格式
        List<Integer> res = new ArrayList<>();

        //1.获取匹配串数组中元素长度和个数，计算总串长度
        int wl = words[0].length();
        int nums = words.length;
        int length = wl * nums;

        //2.使用hashMap来保存匹配串元素以及对应出现的次数
        HashMap<String,Integer> map = new HashMap<>();
        for (String w: words){
            map.put(w,map.getOrDefault(w,0)+1);
        }

        //3.遍历串s，累加到s.length-length处
        for (int i=0;i<=s.length()-length;i++){
            //3.1获取s的i位置往后length长度的串
            String tmp = s.substring(i,i+length);

            //3.2按照wl长度的跳转值去分割tmp字串，并将字串放入tmp_map中
            HashMap<String,Integer> tmp_map = new HashMap<>();
            for (int j=0;j<length;j+=wl){
                String word = tmp.substring(j,j+wl);
                tmp_map.put(word,tmp_map.getOrDefault(word,0)+1);
            }
            //3.3比较这两个map，如果相同，将首位i放入返回结果中
            if (map.equals(tmp_map)) res.add(i);
        }


        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}