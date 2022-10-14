package DayExe.DS2.D7;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public static void main(String[] args) {
        Solution solution = new partitionLabels().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //辅助数组，贪心
        public List<Integer> partitionLabels(String s) {

                int[] last = new int[26];
                int length = s.length();

                //根据这个可以求得字母的最后一次出现的位置，因为i是逐渐增大的，后来的会覆盖前面的
                for (int i = 0; i < length; i++) {
                    last[s.charAt(i) - 'a'] = i;
                }

                List<Integer> partition = new ArrayList<Integer>();

                int start = 0, end = 0;
                for (int i = 0; i < length; i++) {
                    end = Math.max(end, last[s.charAt(i) - 'a']);
                    if (i == end) {
                        partition.add(end - start + 1);
                        start = end + 1;
                    }
                }
                return partition;
            }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
