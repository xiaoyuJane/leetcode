package DayExe.D4;

import java.util.ArrayList;
import java.util.List;

public class generate {
    public static void main(String[] args) {
        Solution solution = new generate().new Solution();
        System.out.println(solution.generate(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<Integer> item = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();

            if (numRows == 1){
                item.add(1);
                res.add(item);
                return res;
            }

            res = generate(numRows-1);
            res.add(generateRow(numRows));
            return res;

        }

        public List<Integer> generateRow(int numRows){
            List<Integer> item = new ArrayList<>(numRows);
            if (numRows == 2) {
                item.add(1);
                item.add(1);
                return item;
            }
            List<Integer> pre = generateRow(numRows-1);
            item.add(1);
            for (int i = 0; i < pre.size()-1; i++) {
                item.add(pre.get(i)+pre.get(i+1));
            }
            item.add(1);
            return item;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
