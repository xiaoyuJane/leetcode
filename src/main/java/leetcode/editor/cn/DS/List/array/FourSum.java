package leetcode.editor.cn.DS.List.array;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 1086 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {

        Solution solution = new FourSum().new Solution();
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> res = solution.fourSum(nums,target);
        for (List<Integer> item : res ){
            System.out.println(Arrays.toString(item.toArray()));
        }

//        测试结果:[[-3,-2,2,3],[-3,-1,1,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//        期望结果:[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();

        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                int k=j+1;
                int l=nums.length-1;

                while (k<l){
                    int sum = nums[i] + nums[j] +nums[k] +nums[l] ;
                    if (sum > target) l--;
                    if (sum < target) k++;
                    if (sum == target){
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        res.add(nums[l]);

                        if (!hashSet.contains(res)){
                            result.add(res);
                            hashSet.add(res);
                        }
                        k++;
                        l--;
                    }

                }
            }
        }



        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}