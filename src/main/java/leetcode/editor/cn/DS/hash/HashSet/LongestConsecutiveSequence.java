package leetcode.editor.cn.DS.hash.HashSet;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 1150 👎 0

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(solution.longestConsecutive(nums));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
    //map可以将查找降到O(1)复杂度，适用于反复查找和归类的情况

class Solution {

    //方法1暴力法，遍历再循环,使用set，时间复杂度n^2
    public int longestConsecutive1(int[] nums) {
        int max = 0;

        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            num.add(nums[i]);
        }
        for (Integer i : num){
            int tmp = 1;
            while (num.contains(++i)) {
                tmp++;
            }
            max = Math.max(tmp,max);
        }

        return max;
    }

    //暴力搜索法浪费了重复的前缀信息，比如x，x+1，x+2遍历完一轮循环后，
    // 下一轮循环又会从x+1开始搜索，其实是浪费了已知的 x+1,x+2这一顺序的。
    // 优化方案在于x+1 这轮循环，如果x已经被搜索了，因为它肯定会被x找上，那么就不再进行x+1的这轮的搜索了，
    public int longestConsecutive(int[] nums){

        //1.使用set去重
        Set<Integer> set = new HashSet<>();
        for(int n :nums){
            set.add(n);
        }
        int max = 0;
        //2.剪枝，做跳出循环的操作
        for (Integer num : set){
            //剪枝操作，如果存在前一个数，那么它迟早会被找上来的，就不做遍历了，
            // 只有它是序列中最小的，才会进入循环进行次数累加
            if (!set.contains(num-1)){
                int tmp = 1;
                while (set.contains(++num)) tmp++;
                max = Math.max(tmp,max);

            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}