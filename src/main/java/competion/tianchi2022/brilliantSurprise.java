package competion.tianchi2022;

import java.util.Arrays;

public class brilliantSurprise {
    public static void main(String[] args) {
        Solution solution = new brilliantSurprise().new Solution();
        int[][] present = {{1,2,100},{4,5},{3,4}};
        System.out.println(solution.brilliantSurprise(present,4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int brilliantSurprise(int[][] present, int limit) {
            for (int i = 0; i < present.length; i++) {
                if (present[i].length>limit){
                    int[] tmp = new int[limit];
                    for (int i1 = 0; i1 < limit; i1++) {
                       tmp[i1] = present[i][i1];
                    }
                    present[i] = tmp;
                }
            }

            Arrays.sort(present,((o1, o2) -> o2[o2.length-1]-o1[o1.length-1]));
            int res=0;
            int count = 0;
            for (int i = 0; i < present.length; i++) {
                for (int i1 = 0; i1 < present[i].length; i1++) {
                    if (count == limit) return res;
                    res +=present[i][i1];
                    count++;
                }
            }
            return res;


        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
