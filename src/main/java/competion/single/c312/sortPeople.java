package competion.single.c312;

import java.util.Arrays;
import java.util.Comparator;

public class sortPeople {
    public static void main(String[] args) {
        Solution solution = new sortPeople().new Solution();
        String[] names = {"Mary","John","Emma"};
        int[] heights={180,165,170};
        System.out.println(Arrays.toString(solution.sortPeople(names,heights)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            int n = names.length;
            Integer[] index = new Integer[n];
            Integer[] height = new Integer[n];
            for (int i = 0; i < n; i++) {
                index[i]=i;
                height[i]=heights[i];
            }

            Arrays.sort(index,((o1, o2) -> height[o2]-height[o1]));
            String[] res = new String[names.length];

            for (int i = 0; i < index.length; i++) {
                res[i] = names[index[i]];
            }
            return res;


        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
