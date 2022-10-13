package DayExe.DS2.D6;

public class addStrings {
    public static void main(String[] args) {
        Solution solution = new addStrings().new Solution();
        String num1="456";
        String num2="77";
        System.out.println(solution.addStrings(num1,num2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int m = num1.length()-1;
            int n = num2.length()-1;
            int tmp = 0; //进位

            StringBuffer res = new StringBuffer();

            while (m>=0 || n>=0 ||tmp!=0){
                int i = m>=0 ? num1.charAt(m) - '0':0;
                int j = n>=0 ? num2.charAt(n) - '0':0;
                int sum = i+j+tmp;
                m--;
                n--;
                int result = sum%10;
                res.append(result);
                tmp = sum/10;

            }

            return res.reverse().toString();


        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
