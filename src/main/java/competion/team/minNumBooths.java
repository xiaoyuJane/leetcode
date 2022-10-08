package competion.team;

import java.util.ArrayList;
import java.util.HashMap;

public class minNumBooths {
    public static void main(String[] args) {
        Solution solution = new minNumBooths().new Solution();
        String[] demand = {"ccluro","mmjhp","ln","ayoqwqtqrh","m","luhnsb","gyyy","auuksw"};
        System.out.println(solution.minNumBooths(demand));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumBooths(String[] demand) {
            int res=0;
            ArrayList<HashMap<Character,Integer>> lists = new ArrayList<>();
            HashMap<Character, Integer> maps = new HashMap<>();
            for (int i = 0; i < demand.length; i++) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (char c : demand[i].toCharArray()) {
                   if (map.containsKey(c)) map.put(c,map.get(c)+1);
                   else map.put(c,1);
                }
                lists.add(map);
            }

            for (HashMap<Character, Integer> item : lists) {
                for (Character key : item.keySet()){
                    if (maps.containsKey(key) && maps.get(key)<item.get(key)) maps.put(key,item.get(key));
                    if (! maps.containsKey(key))maps.put(key,item.get(key));
                }
            }

            for (Integer count : maps.values()){
                res +=count;
            }

            return res;

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
