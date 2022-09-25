package competion.single.c305;

import java.util.*;

public class mergeSimilarItems {
    public static void main(String[] args) {
        Solution solution = new mergeSimilarItems().new Solution();
        int[][] items1 ={{1,1},{4,5},{3,8}};
        int[][] items2 ={{3,1},{1,5}};
        System.out.println(solution.mergeSimilarItems(items1,items2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < items1.length; i++) {
                map.put(items1[i][0],items1[i][1]);
            }
            for (int i = 0; i < items2.length; i++) {
                if (map.containsKey(items2[i][0])) map.put(items2[i][0],map.get(items2[i][0])+items2[i][1]);
                else map.put(items2[i][0],items2[i][1]);
            }
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            ArrayList<Integer> item = new ArrayList<>(2);
            for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
                item.add(entry.getKey());
                item.add(entry.getValue());
                res.add(new ArrayList<>(item));
                item.clear();
            }
            return res;
            
            
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
