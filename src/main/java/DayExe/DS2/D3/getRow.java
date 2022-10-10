package DayExe.DS2.D3;

import java.util.ArrayList;
import java.util.List;

public class getRow {
    public static void main(String[] args) {
        Solution solution = new getRow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //递归
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res = new ArrayList<>();
            if (rowIndex == 0) {
                res.add(1);
                return res;
            }
            if (rowIndex == 1){
                res.add(1);
                res.add(1);
                return res;
            }

            List<Integer> row = getRow(rowIndex - 1);
            res.add(1);
            for (int i = 1; i < row.size(); i++) {
                res.add(row.get(i-1)+row.get(i));
            }
            res.add(1);
            return res;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
