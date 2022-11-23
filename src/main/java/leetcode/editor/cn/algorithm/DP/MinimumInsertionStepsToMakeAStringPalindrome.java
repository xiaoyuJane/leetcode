package leetcode.editor.cn.algorithm.DP;

//给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。 
//
// 请你返回让 s 成为回文串的 最少操作次数 。 
//
// 「回文串」是正读和反读都相同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "zzazz"
//输出：0
//解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
// 
//
// 示例 2： 
//
// 
//输入：s = "mbadm"
//输出：2
//解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
// 
//
// 示例 3： 
//
// 
//输入：s = "leetcode"
//输出：5
//解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 中所有字符都是小写字母。 
// 
// Related Topics 字符串 动态规划 
// 👍 163 👎 0

public class MinimumInsertionStepsToMakeAStringPalindrome{
    public static void main(String[] args) {
        Solution solution = new MinimumInsertionStepsToMakeAStringPalindrome().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //先求s的最长回文子序列s',s-s'即为插入的次数
    public int minInsertions(String s) {
        int n=s.length();
        if (n==1) return 0;

        int[][] dp = new int[n][n]; //dp状态方程，表示i到j的最大回文子序列长度

        //base case
        for (int i = 0; i < n - 1; i++) {
            dp[i][i]=1;
        }
        //自底向上
        for (int i=n-2;i>=0;i--){
            for (int j = i+1; j < n ; j++) {
                //处理特殊情况
//                if (i+1>j-1) dp[i+1][j-1]=0;
                if(s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1]+2;
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }


        //转换下思路变通
        return n-dp[0][n-1];



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}