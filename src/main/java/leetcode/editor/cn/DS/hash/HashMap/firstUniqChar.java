package leetcode.editor.cn.DS.hash.HashMap;
/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 *
 * 提示:
 *
 * 1 <= s.length <= 105
 * s 只包含小写字母
 * 相关标签
 * 队列
 * 哈希表
 * 字符串
 * 计数

 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class firstUniqChar {
    public static void main(String[] args) {
        Solution solution = new firstUniqChar().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //LinkedHashMap 是根据插入有序的
        public int firstUniqChar(String s) {

            Map<Character,Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),1);
                }else{
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }
            }

            //遍历map
            for (Map.Entry<Character, Integer> entry:map.entrySet()){
                if (entry.getValue() == 1) return s.indexOf(entry.getKey());
            }

            return  -1;
        }


        public int firstUniqChar1(String s){
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),1);
                }else{
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) return i;
            }

            return -1;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
