package competion.single.c314;

public class findArray {
    public static void main(String[] args) {
        Solution solution = new findArray().new Solution();
        int[] pref = {13};
        System.out.println(solution.findArray(pref));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findArray(int[] pref) {
            int[] res = new int[pref.length];
            res[0]=pref[0];
            for (int i = 1; i < pref.length; i++) {
                 res[i] = pref[i] ^ pref[i-1] ;
            }
           return res;
        }


    }
//leetcode submit region begin(Prohibit modification and deletion)
}
