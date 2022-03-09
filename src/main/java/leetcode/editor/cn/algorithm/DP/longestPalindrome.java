package leetcode.editor.cn.algorithm.DP;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 *相关标签
 * 字符串
 * 动态规划
 */

public class longestPalindrome {
    public static void main(String[] args) {
        Solution solution = new longestPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len ==1) return s;

            int resIndex =0,resLen=1; //结果数据

            //使用动态规划，状态方程为dp[i][i] =s.charAt(i)==s.charAt(j) && dp[i+1][j-1]
            boolean[][] dp = new boolean[len][len];//使用二维布尔数组存放i位到j位是否为回文串
            for (int i=0;i<len;i++) dp[i][i] = true;//初始化dp数组

            for (int j=1;j<len;j++){
                for (int i=0;i<j;i++){//i在前，j在后
                    if (s.charAt(i)!=s.charAt(j)) dp[i][j] = false;
                    else {
                        if (j-i < 3) dp[i][j] = true;//字符串长度3以内，直接为true，不需要比较
                        else dp[i][j] = dp[i+1][j-1]; //迭代
                    }
                    //更新，使用最长的resLen
                    if (dp[i][j] && j-i+1 >resLen){
                        resIndex =i;
                        resLen = j-i+1;
                    }
                }

            }
            return s.substring(resIndex,resIndex+resLen);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
