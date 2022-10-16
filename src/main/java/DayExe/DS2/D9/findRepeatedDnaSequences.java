package DayExe.DS2.D9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 *
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 *
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i]=='A'、'C'、'G' or 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findRepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new findRepeatedDnaSequences().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)
        // 一个哈希表统计 s 所有长度为 10 的子串的出现次数，返回所有出现次数超过1次 的子串。

        public List<String> findRepeatedDnaSequences(String s) {
            ArrayList<String> res = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i <= s.length()-10; i++) {
                String sub = s.substring(i, i + 10);
                map.put(sub,map.getOrDefault(sub,0)+1);
                if (map.get(sub) ==2) res.add(sub); //防止多添加了元素

            }
            return res;

        }

        //滑动窗口与位运算有点关系，都是滑动
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
