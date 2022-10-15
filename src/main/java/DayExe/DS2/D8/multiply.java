package DayExe.DS2.D8;

public class multiply {
    public static void main(String[] args) {
        Solution solution = new multiply().new Solution();
        String num1 = "2";
        String num2 = "3";
        System.out.println(solution.multiply(num1,num2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //迭代
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";

            char[] ch2 = num2.toCharArray();
            char[] ch1 = num1.toCharArray();
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < ch2.length; i++) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < ch2.length-1-i; j++) {
                    tmp.append("0");
                }
                int b = ch2[i]-'0';
                int carry=0;
                for (int j = ch1.length-1; j >=0; j--) {
                    int div =(ch1[j]-'0')*(ch2[i]-'0') +carry;
                    tmp.append(div%10);
                    carry = div/10;
                }
                if (carry>0) tmp.append(carry);
                res = add(res,tmp.reverse());
            }
            return res.toString();
        }

        //nums1 nums2 size>=1
        private StringBuilder add(StringBuilder num1, StringBuilder num2){
            if (num1.length()==0 ||num2.length()==0) return num1.length()==0? num2: num1;
            StringBuilder res = new StringBuilder();
            int n1= num1.length()-1;
            int n2 = num2.length()-1;
            int carry =0;
            while (n1>=0 ||n2>=0 ||carry!=0){
                int index1 = n1>=0 ? num1.charAt(n1)-'0':0;
                int index2 = n2>=0 ? num2.charAt(n2)-'0':0;
                int sum = index1+index2+carry;
                res.append(sum%10);
                carry = sum/10;
                n1--;
                n2--;
            }
            return res.reverse();
        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
