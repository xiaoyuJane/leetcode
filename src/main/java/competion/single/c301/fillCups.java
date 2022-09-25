package competion.single.c301;

import java.util.Arrays;

//数学题
//思想用到贪心算法
public class fillCups {
    public static void main(String[] args) {
        Solution solution = new fillCups().new Solution();
        int[] amount ={5,4,4};
        System.out.println(Math.round(1.5));
//        System.out.println(solution.fillCups(amount));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fillCups(int[] amount) {
            Arrays.sort(amount);
            System.out.println(Arrays.toString(amount));

            if (amount[0]+amount[1]<=amount[2]) return amount[2];
            else return (int) (amount[2]+Math.round((amount[0]+amount[1]-amount[2])/2.0));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
