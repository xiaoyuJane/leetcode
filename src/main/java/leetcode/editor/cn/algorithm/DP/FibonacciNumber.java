package leetcode.editor.cn.algorithm.DP;

//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 
// 👍 555 👎 0

/**
 * 解题思路：
 * 但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助
 * 递归算法的时间复杂度怎么计算？就是用子问题个数乘以解决一个子问题需要的时间。
 * 首先计算子问题个数，即递归树中节点的总数。显然二叉树节点总数为指数级别，所以子问题个数为 O(2^n)。
 *
 * 观察递归树，很明显发现了算法低效的原因：存在大量重复计算，
 * 比如 f(18) 被计算了两次，而且你可以看到，以 f(18) 为根的这个递归树体量巨大，多算一遍，会耗费巨大的时间。
 * 更何况，还不止 f(18) 这一个节点被重复计算，所以这个算法及其低效。
 * 这就是动态规划问题的第一个性质：重叠子问题。下面，我们想办法解决这个问题
 *
 * 备忘录：
 * 明确了问题，其实就已经把问题解决了一半。即然耗时的原因是重复计算，那么我们可以造一个「备忘录」，
 * 每次算出某个子问题的答案后别急着返回，先记到「备忘录」里再返回；
 * 每次遇到一个子问题先去「备忘录」里查一查，如果发现之前已经解决过这个问题了，直接把答案拿出来用，不要再耗时去计算了。
 * 一般使用一个数组充当这个「备忘录」，当然你也可以使用哈希表（字典），思想都是一样的。
 * 带「备忘录」的递归算法，把一棵存在巨量冗余的递归树通过「剪枝」，改造成了一幅不存在冗余的递归图，极大减少了子问题（即递归图中节点）的个数。
 *
 */

public class FibonacciNumber{
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //这种解法是「自顶向下」进行「递归」求解
    public int fib1(int n) {
        //备忘录
        int[] memo = new int[n + 1];
        return helper(memo,n);

    }

    private int helper(int[] memo, int n){
        //base case
        if (n==0||n==1) return n;

        //查找备忘录
        if(memo[n]!=0) return memo[n];
        //没找到
        memo[n] = helper(memo,n-1)+helper(memo,n-2);
        return memo[n];

    }

    //传统的递归方式
    public int fib2(int n) {
        if(n==0 || n==1) return n;
        return fib2(n-1)+fib2(n-2);
    }

    //自顶向下，dp数组的迭代（递推）解法
    //可见列出「状态转移方程」的重要性，它是解决问题的核心，而且很容易发现，其实状态转移方程直接代表着暴力解法。
    //千万不要看不起暴力解，动态规划问题最困难的就是写出这个暴力解，即状态转移方程。
    //只要写出暴力解，优化方法无非是用备忘录或者 DP table，再无奥妙可言。
    public int fib(int n) {
       if (n==0) return 0;
       int[] dp = new int[n+1];

       dp[0]=0;
       dp[1]=1;

       //状态转移,从底向上就可以复用结果
       //一旦一个子问题的求解得到结果，以后的计算过程就不会修改它，这样的特点叫做无后效性
        // 求解问题的过程形成了一张有向无环图。动态规划只解决每个子问题一次，具有天然剪枝的功能，从而减少计算量
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];  //状态转移方程：f(n) 的函数参数会不断变化，
            // 所以你把参数 n 想做一个状态，这个状态 n 是由状态 n - 1 和状态 n - 2 转移（相加）而来，这就叫状态转移，仅此而已。
        }
        return dp[n];

    }

    //进一步优化空间复杂度
    public int fib4(int n){
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int  i1= 1, i0 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int tmp = i0 + i1;
            // 往前滚动更新
            i0 = i1;
            i1 = tmp;
        }
        return i1;
    }




}
//leetcode submit region end(Prohibit modification and deletion)

}