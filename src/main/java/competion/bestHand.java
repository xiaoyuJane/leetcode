package competion;
//提示：
//
//ranks.length == suits.length == 5
//1 <= ranks[i] <= 13
//'a' <= suits[i] <= 'd'
//任意两张扑克牌不会同时有相同的大小和花色。

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class bestHand {
    public static void main(String[] args) {
        Solution solution = new bestHand().new Solution();
        int[] ranks = {10,10,2,12,9};
        char[] suits = {'a','b','c','a','d'};
        System.out.println(solution.bestHand(ranks,suits));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            String[] results = {"Flush","Three of a Kind","Pair","High Card"};

            char suit = suits[0];
            boolean fl = true;
            for (int i = 1; i < 5; i++) {
                if (suits[i] != suit) {
                    fl = false;
                    break;
                }
            }
            if (fl) return results[0];

            boolean flag = false;
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < 5; i++) {
               if (map.containsKey(ranks[i])) map.put(ranks[i],map.get(ranks[i])+1);
               else map.put(ranks[i],1);
               if (map.get(ranks[i])==3)  flag=true;
            }
            if (flag) return results[1];

            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                if (integerIntegerEntry.getValue() ==2) return results[2];
            }
            return results[3];
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
