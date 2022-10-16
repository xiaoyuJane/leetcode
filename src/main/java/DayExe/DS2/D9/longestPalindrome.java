package DayExe.DS2.D9;

public class longestPalindrome {
    public static void main(String[] args) {
        Solution solution = new longestPalindrome().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划法
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n <2) return s;

            int maxLen =1;
            int begin =0;
            boolean[][] dp = new boolean[n][n]; //默认值为false
            for (int i = 0; i < n; i++) {
                dp[i][i]=true;
            }

            char[] chars = s.toCharArray();
            for (int len = 2; len <=n; len++) {
                for (int i = 0; i < n; i++) {
                    int j= i+len-1; //i和j之间的距离为len，有len=j-i+1
                    if (j>=n) break;
                    //回文串的判断
                    if (chars[i]!=chars[j]) dp[i][j]=false;
                    else {
                        if (j-i<3) dp[i][j]=true;
                        else dp[i][j]=dp[i+1][j-1];  //todo 动态规划也是利用递归的思想，使用数组中的值
                    }

                    if (dp[i][j] && j-i+1>maxLen){
                        maxLen = j-i+1;
                        begin = i;
                    }

                }
            }
            return s.substring(begin,begin+maxLen);

        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
