package competion.single.c313;

public class minimizeXor {
    public static void main(String[] args) {
        Solution solution = new minimizeXor().new Solution();
        System.out.println(solution.minimizeXor(1,15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimizeXor(int num1, int num2) {
            StringBuilder s1 = new StringBuilder(Integer.toBinaryString(num1));
            String s2 = Integer.toBinaryString(num2);
            String res = String.valueOf(s1);

            int count = getCount(s2);

            while (s1.length()<s2.length()){
                s1.insert(0, "0");
            }
            System.out.println(s1);

            //todo 计算count个数的res，使得res^num1最小
            int remain = count - getCount(s1.substring(0,s1.length()-count));
            for (int i = count; i < res.length(); i++) {

            }




        return Integer.parseInt(res,2);
        }

        private int getCount(String s2){
            int count = 0;
            for (char c : s2.toCharArray()) {
                if (c =='1') count++;
            }
            return count;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
