package leetcode.editor.cn.array;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 477 👎 0

import java.util.*;

public class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = solution.intersection(nums1,nums2);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer,Integer> map =new HashMap<>();

        for (int i=0;i<nums1.length;i++){
            map.put(nums1[i],0);
        }

        for (int j=0;j<nums2.length;j++){
            if (map.containsKey(nums2[j])) map.put(nums2[j],1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() ==1) res.add(entry.getKey());
        }

        int[] result = new int[res.size()];
        for (int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}