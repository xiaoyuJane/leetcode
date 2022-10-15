package DayExe.DS2.D8;

import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {
        Solution solution = new groupAnagrams().new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();

            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
               if (!map.containsKey(Arrays.toString(chars))) {
                   List<String> tmp = new ArrayList<>();
                   tmp.add(strs[i]);
                   map.put(Arrays.toString(chars),tmp);
               }else {
                   List<String> tmp = map.get(Arrays.toString(chars));
                   tmp.add(strs[i]);
//                   map.put(Arrays.toString(chars),tmp);
               }
            }

             return  new ArrayList<List<String>>(map.values());


        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
