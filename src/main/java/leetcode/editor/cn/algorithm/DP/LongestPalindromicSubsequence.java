package leetcode.editor.cn.algorithm.DP;

//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 906 👎 0

public class LongestPalindromicSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //最长的回文子序列，并返回该序列的长度 == 最长的回文子序列的长度 == 回文子序列中求取最大长度
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];  //定义为i位置到j位置的子序列的最大回文串长度


        //base case
        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }

        //从底向上
        for (int i = n-2;i>=0; i--){
            for (int j= i+1;j<n;j++){
                //状态方程，回文串的判断，固定了i和j的位置
                // i和j位置上相等，皆大欢喜，得到了递推的最大值
                if (i+1>j-1) dp[i+1][j-1]=0;
                if (s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1]+2;
                //i和j位置不相等，i到j的最大值只能从i到j-1上找或者i-1到j上找，此处都各牺牲了一个字符
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }

        return dp[0][n-1];





    }
}
//leetcode submit region end(Prohibit modification and deletion)

}